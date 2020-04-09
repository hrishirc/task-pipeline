package job;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import job.contract.Input;
import job.contract.Output;
import job.contract.Payload;
import job.task.DefaultWarningsAnalyzer;
import job.task.Emitter;
import job.task.InputValidator;
import job.task.OutputMaker;
import job.task.PayloadMaker;
import job.task.PayloadValidator;
import job.task.WarningsAnalyzer;
import job.task.Worker;
import pipeline.Start;
import pipeline.Task;
import pipeline.TaskPipeline;

public abstract class Job<I extends Input, P extends Payload<I>, O extends Output> {

  private Class<I> inputClass;
  private Class<P> dataClass;
  private Class<O> respClass;

  private Map<Class, Task<Object, I>> reducers = new HashMap<>();

  private TaskPipeline<I, O> taskPipeline;

  public Job() {
    final Type[] typeArgs =
        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
    inputClass = (Class<I>) typeArgs[0];
    dataClass = (Class<P>) typeArgs[1];
    respClass = (Class<O>) typeArgs[2];
  }

  public O work(Object input) {

    if (taskPipeline == null) {
      taskPipeline =
          new Start<>(inputClass, getClass().getSimpleName())
              .with(reducers)
              .attach(getInputValidator())
              .attach(getPayloadMaker())
              .attach(getPayloadValidator())
              .attach(getWarningsAnalyzer())
              .attach(getWorker())
              .attach(getEmitter())
              .attach(getOutputMaker())
              .finish();
    }

    return taskPipeline.work(input);
  }

  protected abstract InputValidator<I> getInputValidator();

  protected abstract PayloadMaker<I, P> getPayloadMaker();

  protected abstract PayloadValidator<P> getPayloadValidator();

  protected abstract Worker<P> getWorker();

  protected abstract Emitter<P> getEmitter();

  protected abstract OutputMaker<P, O> getOutputMaker();

  protected WarningsAnalyzer<P> getWarningsAnalyzer() {
    return new DefaultWarningsAnalyzer<>();
  }

  protected <T> void add(Class<T> tClass, Task<T, I> reducer) {
    reducers.put(tClass, (Task<Object, I>) reducer);
  }
} /*end of AbstractOperation.java*/

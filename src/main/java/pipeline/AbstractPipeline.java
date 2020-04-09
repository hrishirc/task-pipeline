package pipeline;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractPipeline<I, O> {
  protected Logger log = LoggerFactory.getLogger(getClass());

  private Class<I> inputClass;

  private String name;
  private Task<I, ?> startTask;
  private ExceptionHandler exceptionHandler;
  private Map<Class, Task<Object, I>> reducers = new HashMap<>();

  protected AbstractPipeline() {
    //    final Type[] typeArgs =
    //        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
    //    this.inputClass = (Class<I>) typeArgs[0];
  }

  protected AbstractPipeline(AbstractPipeline<I, ?> pipeline) {
    this.name = pipeline.name;
    this.startTask = pipeline.startTask;
    this.exceptionHandler = pipeline.exceptionHandler;
    this.reducers = pipeline.reducers;
    this.inputClass = pipeline.inputClass;
  }

  protected Class<I> getInputClass() {
    return inputClass;
  }

  public void setInputClass(Class<I> inputClass) {
    this.inputClass = inputClass;
  }

  protected String getName() {
    return name;
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected Task<I, ?> getStartTask() {
    return startTask;
  }

  public void setStartTask(Task<I, ?> startTask) {
    this.startTask = startTask;
  }

  protected ExceptionHandler getExceptionHandler() {
    return exceptionHandler != null ? exceptionHandler : ExceptionHandler.getDefault();
  }

  protected void setExceptionHandler(ExceptionHandler exceptionHandler) {
    this.exceptionHandler = exceptionHandler;
  }

  protected <IZ> Task<IZ, I> getReducer(Class<IZ> rawInputClass) {
    return (Task<IZ, I>) reducers.get(rawInputClass);
  }

  protected <IZ> void addReducer(Class<IZ> rawInputClass, Task<IZ, I> reducer) {
    reducers.put(rawInputClass, (Task<Object, I>) reducer);
  }
} /*end of BlankPipeline.java*/

package pipeline;

public class Start<I> extends UnderConstruction<I, I> {
  public Start(Class<I> inputClass, String name) {

    log.info(
        "Started creating pipeline " + name + " for input of type " + inputClass.getSimpleName());

    this.setInputClass(inputClass);
    this.setName(name);
  }
}

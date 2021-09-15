package handler;

public class LogExceptionHandler implements IExceptionHandler {
    @Override
    public void handle(Exception e) {
        e.printStackTrace();
    }
}

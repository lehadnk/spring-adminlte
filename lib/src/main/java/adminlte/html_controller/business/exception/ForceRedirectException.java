package adminlte.html_controller.business.exception;

public class ForceRedirectException extends RuntimeException {
    public ForceRedirectException(String redirectUrl) {
        super(redirectUrl);
    }
}

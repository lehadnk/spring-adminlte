package adminlte.flash_message.business;

import adminlte.authentication.AuthenticationServiceInterface;
import adminlte.flash_message.dto.FlashMessageData;
import adminlte.session.SessionServiceInterface;

import java.util.ArrayList;

public class FlashMessageSessionStore {
    private final AuthenticationServiceInterface authenticationService;
    private final SessionServiceInterface sessionService;

    public FlashMessageSessionStore(
            AuthenticationServiceInterface authenticationService,
            SessionServiceInterface sessionService
    ) {
        this.authenticationService = authenticationService;
        this.sessionService = sessionService;
    }

    public FlashMessageData getFlashMessageData() {
        var userId = this.authenticationService.getCurrentUserIdentifier();

        var flashMessageData = new FlashMessageData();

        var adminSessionData = this.sessionService.getUserSessionData(userId);
        if (adminSessionData != null) {
            if (adminSessionData.errorMessages.size() > 0) {
                flashMessageData.errorMessage = String.join(". ", adminSessionData.errorMessages);
                adminSessionData.errorMessages = new ArrayList<>();
            }
            if (adminSessionData.successMessages.size() > 0) {
                flashMessageData.successMessage = String.join(". ", adminSessionData.successMessages);
                adminSessionData.successMessages = new ArrayList<>();
            }

            if (flashMessageData.successMessage != null || flashMessageData.errorMessage != null) {
                this.sessionService.setUserSessionData(userId, adminSessionData);
            }
        }

        return flashMessageData;
    }

    public void addErrorMessage(String message) {
        var currentUserId = this.authenticationService.getCurrentUserIdentifier();
        var currentUserSessionData = this.sessionService.getUserSessionData(currentUserId);
        currentUserSessionData.errorMessages.add(message);

        this.sessionService.setUserSessionData(currentUserId, currentUserSessionData);
    }

    public void addSuccessMessage(String message) {
        var currentUserId = this.authenticationService.getCurrentUserIdentifier();
        var currentUserSessionData = this.sessionService.getUserSessionData(currentUserId);
        currentUserSessionData.successMessages.add(message);

        this.sessionService.setUserSessionData(currentUserId, currentUserSessionData);
    }
}

package adminlte.flash_message;

import adminlte.flash_message.business.FlashMessageSessionStore;
import adminlte.flash_message.dto.FlashMessageData;

public class FlashMessageService {

    private final FlashMessageSessionStore flashMessageSessionStore;

    public FlashMessageService(
            FlashMessageSessionStore flashMessageSessionStore
    ) {
        this.flashMessageSessionStore = flashMessageSessionStore;
    }

    public FlashMessageData getFlashMessageData()
    {
        return this.flashMessageSessionStore.getFlashMessageData();
    }

    public void addErrorMessage(String message) {
        this.flashMessageSessionStore.addErrorMessage(message);
    }

    public void addSuccessMessage(String message) {
        this.flashMessageSessionStore.addSuccessMessage(message);
    }
}

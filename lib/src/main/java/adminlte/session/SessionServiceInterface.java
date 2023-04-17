package adminlte.session;

import adminlte.session.dto.SessionData;

public interface SessionServiceInterface {
    SessionData getUserSessionData(Integer userId);
    void setUserSessionData(Integer userId, SessionData sessionData);
}

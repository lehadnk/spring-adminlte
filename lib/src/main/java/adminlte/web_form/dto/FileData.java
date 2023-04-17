package adminlte.web_form.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileData {
    private MultipartFile file;
    private String fileUrl;
    private String fileDelete;

    public boolean isDelete() {
        return this.fileDelete != null && !this.fileDelete.isBlank();
    }

    public boolean hasFile() {
        return !this.isDelete() && this.file != null && !this.file.isEmpty();
    }

    private void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        if (this.fileUrl == null) {
            return null;
        }
        if (this.fileUrl.isBlank()) {
            return null;
        }
        return this.fileUrl;
    }

    public static FileData from(String fileUrl) {
        if (fileUrl == null) {
            return null;
        }
        var fd = new FileData();
        fd.setFileUrl(fileUrl);
        return fd;
    }
}

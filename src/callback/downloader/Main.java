package callback.downloader;

class FileDownloader {
    interface FileDownloadProgressCallback {
        void updateProgress(int percentage);
    }

    public void downloadFile(String filePath, FileDownloadProgressCallback callback) {
        // simulate downloading progress
        for (int percentage = 0; percentage <= 100; percentage += 10) {
            // update the progress every 10%
            callback.updateProgress(percentage);

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloadFile("http://.../myFile.txt", new FileDownloader.FileDownloadProgressCallback() {
            @Override
            public void updateProgress(int percentage) {
                System.out.println("Loading progress: " + percentage + "%");
            }
        });
    }
}

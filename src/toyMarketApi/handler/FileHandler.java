package toyMarketApi.handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileHandler {
    public boolean save(String saveText, String fileName) throws RuntimeException {
        if (saveText != null)
            try {
                File file = new File(fileName);
                file.createNewFile();
                StringBuilder text = new StringBuilder();
                String fileText = read(file);
                if (fileText != null) text.append(fileText);
                text.append(saveText);
                return write(file, String.valueOf(text));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return false;
    }

    private String read(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        return result.toString();
    }

    private boolean write(File file, String text) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath())){
            bufferedWriter.write(text);
            return true;
        }
    }
}

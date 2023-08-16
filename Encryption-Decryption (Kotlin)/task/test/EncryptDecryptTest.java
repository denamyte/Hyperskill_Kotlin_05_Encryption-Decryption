import org.hyperskill.hstest.common.FileUtils;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EncryptDecryptTest extends StageTest<String> {

    @Override
    public List<TestCase<String>> generate() {
        return List.of(
            new TestCase<String>()
                .addArguments(
                    "-mode", "enc",
                    "-key", "5",
                    "-in", "in.txt",
                    "-out", "output.txt"
                )
                .setAttach("\\jqhtrj%yt%m~ujwxpnqq&")
                .addFile("in.txt", "Welcome to hyperskill!"),

            new TestCase<String>()
                .addArguments(
                    "-key", "0",
                    "-mode", "enc",
                    "-in", "input.txt",
                    "-out", "output.txt"
                )
                .setAttach("Hello")
                .addFile("input.txt", "Hello"),

            new TestCase<String>()
                .addArguments(
                    "-key", "1",
                    "-in", "i.txt",
                    "-out", "output.txt",
                    "-mode", "enc"
                )
                .setAttach("123456789")
                .addFile("i.txt", "012345678"),

            new TestCase<String>()
                .addArguments(
                    "-mode", "dec",
                    "-in", "input.txt",
                    "-out", "output.txt",
                    "-key", "5"
                )
                .setAttach("Welcome to hyperskill!")
                .addFile("input.txt", "\\jqhtrj%yt%m~ujwxpnqq&"),

            new TestCase<String>()
                .addArguments(
                    "-mode", "dec",
                    "-key", "0",
                    "-in", "input.txt",
                    "-out", "output.txt"
                )
                .setAttach("Hi")
                .addFile("input.txt", "Hi"),

            new TestCase<String>()
                .addArguments(
                    "-mode", "dec",
                    "-key", "1",
                    "-in", "input.txt",
                    "-out", "output.txt"
                )
                .setAttach("111122223333")
                .addFile("input.txt", "222233334444")
        );
    }

    @Override
    public CheckResult check(String reply, String clue) {
        String fileName = "output.txt";
        String output;

        try {
            Path path = Paths.get(FileUtils.CURRENT_DIR + fileName);
            output = Files.readString(path, StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            return new CheckResult(false, "File output.txt not found!");
        } catch (IOException e) {
            return new CheckResult(false, "Cannot read from file!");
        }

        if (!output.trim().equals(clue.trim())) {
            return new CheckResult(false, "Wrong result in the file!");
        }

        return new CheckResult(true);
    }
}

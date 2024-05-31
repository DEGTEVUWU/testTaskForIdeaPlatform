
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

public class Main implements Callable {
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Override
    public Integer call() throws Exception {
        try {
            DataCounting.generate(filePath1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCESS_EXIT_CODE;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}

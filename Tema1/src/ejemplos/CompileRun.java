package ejemplos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CompileRun {

	public static void main(String[] args) {

		try {
			runProcess("cmd /c");
			System.out.println("**********");
			runProcess("javac -cp src ejemplos/Test.java");
			System.out.println("**********");
			runProcess("java -cp src ejemplos/Test Hola Jorge");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + " " + line);
		}
	}

	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}

}

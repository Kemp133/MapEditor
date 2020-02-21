import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class UILabelLanguageResources extends ResourceBundle {

	protected        HashMap<String, String> labels;
//	protected static String                  resourceFileLocation;
//	protected static String                  delimeter;

	{
		labels = new HashMap<>();
	}

	UILabelLanguageResources(String fileLocation, String delimeter) throws Exception {
		String line;
		List<Integer> lineErrors = new LinkedList<>();

		try (FileReader fr = new FileReader(fileLocation)) {
			try (BufferedReader br = new BufferedReader(fr)) {
				line = br.readLine();

				if (line == null) throw new Exception("The designated file is empty!");

				int rowCount = 2;

				while ((line = br.readLine()) != null) {
					String[] keyValuePair = line.split(delimeter);

					if (keyValuePair.length != 2) {
						lineErrors.add(rowCount++);
						continue;
					}

					labels.put(keyValuePair[0], keyValuePair[1]);
				}

				if (lineErrors.size() > 0) {
					br.close();
					fr.close();

					throw new Exception(createErrorMessage(fileLocation, lineErrors));
				}
			}
		}
	}

	private String createErrorMessage(String fileLocation, List<Integer> lineErrors) {
		StringBuilder sb = new StringBuilder();
		sb.append("Loading of the Resource Pack ");
		sb.append(Path.of(fileLocation).getFileName().toString());
		sb.append(" failed! There were errors on the following lines: ");
		sb.append(lineErrors.get(0));

		for (Integer i : lineErrors.subList(2, lineErrors.size())) {
			sb.append(", ");
			sb.append(i);
		}

		return sb.toString();
	}

	@Override
	protected Object handleGetObject(String key) {
		return labels.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return new CSVEumerator<>(labels.keySet().iterator());
	}
}

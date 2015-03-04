/**
 * 
 */
package com.catalyst.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chamath This class finds files of a node for a query
 */
class FileSearcher {
	/**
	 * List of file names of the node
	 */
	private List<String> nodeFileNames;

	/**
	 * @param nodeFileNames
	 *            filenames of the node must be given
	 */
	FileSearcher(List<String> nodeFileNames) {
		this.nodeFileNames = nodeFileNames;
	}

	/**
	 * @param query
	 *            for search of filename
	 * @return list of filenames matching query
	 */
	public List<String> getFilesWithNameQuery(String query) {
		String regexQueryWithOrOperator = query.replace('_', '|');
		String pattern = ".*\\b" + regexQueryWithOrOperator + "\\b.*";

		List<String> filenamesForQuery = new ArrayList<String>();
		for (int i = 0; i < nodeFileNames.size(); i++) {
			String filename = nodeFileNames.get(i);
			if (filename.matches(pattern)) {
				filenamesForQuery.add(filename);
			}
		}

		return filenamesForQuery;
	}
}
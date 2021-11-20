package pramp;

/**
 * https://www.pramp.com/challenge/8noLWxLP6JUZJ2bA2rnx
 * @author baibhav <baibhavr@gmail.com>
 * 12:48:16 PM Nov 11, 2021
 */
public class DecryptMessage {
	static String decrypt(String word) {

		if (word.length() == 0)
			return word;

		char prev = word.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append((char) (prev - 1));

		for (int i = 1; i < word.length(); i++) {

			char cur = word.charAt(i);

			int temp = cur - prev;
			while (temp < 'a')
				temp += 26;

			sb.append((char) temp);
			prev = cur;
		}
		return sb.toString();
	}
}

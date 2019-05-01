import java.util.*;
import java.io.*;
import com.jsync.encryptdecrypt.CryptoUtils;

public class CryptoTest{
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Directory Name");
		String dirName = scan.next();
		System.out.println("Enter the key");
		String key = scan.next();

		ArrayList<String> listOfFiles = new ArrayList<>();

		File files = new File(dirName);
		String[] s = files.list();

		for (int i=0; i < s.length ; i++) {
			File file = new File(dirName + "/" + s[i]);
			if (file.isDirectory()) {
				System.out.println(s[i] + " is a Directory");
			}else{
				System.out.println(s[i]);
				listOfFiles.add(s[i]);
				
			}
		}

		System.out.println("\n ********* Only Files *********");

		for (int i = 0; i < listOfFiles.size(); i++) {
			System.out.println(listOfFiles.get(i));
			File file = new File(dirName + "/" + listOfFiles.get(i));
			CryptoUtils.decrypt(key, file, new File(dirName + "/../Decrypted/", listOfFiles.get(i)));
			//CryptoUtils.encrypt(key, file, new File(dirName + "/../Encrypted/", listOfFiles.get(i)));
		}

	}
}
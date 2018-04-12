import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class FeHeroes {

	public static void main(String[] args) throws Exception {

		// Make a URL to the web page
		URL url = new URL("https://feheroes.gamepedia.com/Stats_Table");

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is =con.getInputStream();

		// Once you have the Input Stream, it's just plain old Java IO stuff.

		// For this case, since you are interested in getting plain-text web page
		// I'll use a reader and output the text content to System.out.

		// For binary content, it's better to directly read the bytes from stream and write
		// to the target file.





		/*********************************************************************************
		 * *******************************************************************************
		 * ************************* WRITING SPECIFIC LINE TO FILE ***********************
		 * *******************************************************************************
		 * *******************************************************************************/
		String filename = "FeHeroesHTML.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = "";

		FileOutputStream fos = new FileOutputStream(filename);
		PrintWriter pw = new PrintWriter(fos);
		// read each line and write to System.out
		while (line  != null) {
			line = br.readLine();

			//			System.out.println(pString(line));
			//			writeToFile("FeHeroesHTML.txt", line);

			if (line != null && line.contains("<table "))
				pw.println(line);


		}
		if (pw != null)
			pw.close();
		if (fos != null)
			fos.close();

		/*********************************************************************************
		 * *******************************************************************************
		 * ********************* WRITING SPECIFIC LINE TO FILE END ***********************
		 * *******************************************************************************
		 * *******************************************************************************/

		/*********************************************************************************
		 * *******************************************************************************
		 * ***************** PARSING THROUGH ONE LINE INTO ARRAYLIST *********************
		 * *******************************************************************************
		 * *******************************************************************************/
		FileInputStream fis = new FileInputStream(filename);
		Scanner sc = new Scanner(fis);
		sc.useDelimiter("<tr ");

		ArrayList<String> array = new ArrayList<String>();

		while (sc.hasNext()) {
			String s = sc.next();
			array.add(s);
			//			System.out.println(s);
		}

		/*********************************************************************************
		 * *******************************************************************************
		 * ************** PARSING THROUGH ONE LINE INTO ARRAYLIST END ********************
		 * *******************************************************************************
		 * *******************************************************************************/

		/*********************************************************************************
		 * *******************************************************************************
		 * ************************* PARSING THROUGH ARRAYLIST ***************************
		 * *******************************************************************************
		 * *******************************************************************************/

		ArrayList<Hero> heroesList = new ArrayList<Hero>();
		ArrayList<String> temp = new ArrayList<String>();

		String cType = "";
		String wType = "";
		int health = 0;
		int attack = 0;
		int speed = 0;
		int defense = 0;
		int resistance = 0;
		
		//		HashMap<String, Hero> heroes = new HashMap<String, Hero>();
		HashMap<String, String> heroes = new HashMap<String, String>();
		ArrayList<String> names = new ArrayList<String>();

		/************************************ NAMES **************************************/

		for (int i = 1; i < array.size(); i++) {
			String s = array.get(i);
			int start = s.indexOf("title=") + 7;
			String name = "";
			boolean keepGoing = true;
			while (keepGoing) {

				if (s.charAt(start) == '&') {
					start += 5;
					name += "\'";
				}
				String sub = s.charAt(start)+"";
				if (Character.isAlphabetic(s.charAt(start)) || s.charAt(start) != '\"')  {
					name += sub;
					start++;
				}
				else {
					keepGoing = false;
					names.add(name);

				}
			}
		}

		/********************************* NAMES END *************************************/
		Scanner typesSc = null;
		Scanner statsSc = null;
		for (int i = 1; i < array.size(); i++) {
			String s = array.get(i);
			typesSc = new Scanner(s).useDelimiter("data-");

			/************************************ TYPES **************************************/
			while (typesSc.hasNext()){
				String a = typesSc.next().replace("weapon-type=", "").replace("move-type=", "").replace("sort-value=", "").replace("\"", "").trim();
				if (!Character.isAlphabetic(a.charAt(0))) {
					//					System.out.println("this is the sort value crap");
					if (typesSc.hasNext())
						typesSc.next();
				}
				else {
					if (a.contains("Blue") || a.contains("Red") || a.contains("Green") || a.contains("Colorless")) {
						wType = a;
					}
					else if (Character.isUpperCase(a.charAt(0))){
						if (a.contains("Inf"))
							cType = "Infantry";
						else if (a.contains("Cav"))
							cType = "Cavalry";
						else if (a.contains("Arm"))
							cType = "Armored";
						else
							cType = "Flying";
					}
				}
			}
			typesSc.close();
			/******************************** TYPES END **************************************/
			statsSc = new Scanner(s).useDelimiter("<td>");
			
			while (statsSc.hasNext()) {
				String a = statsSc.next().replace("</td>", "").replace("</tr>", "").replace("</table>", "");
				if (!a.contains("class") && !a.contains("title")) {
					health = Integer.parseInt(a);
					attack = Integer.parseInt(statsSc.next().replace("</td>", "").replace("</tr>", ""));
					speed = Integer.parseInt(statsSc.next().replace("</td>", "").replace("</tr>", ""));
					defense = Integer.parseInt(statsSc.next().replace("</td>", "").replace("</tr>", ""));
					resistance = Integer.parseInt(statsSc.next().replace("</td>", "").replace("</tr>", ""));
					statsSc.next();
				}
			}
			heroesList.add(new Hero(names.get(i-1), cType, wType, health, attack, speed, defense, resistance, "a", "b", "c", "d", "e", "f"));
			statsSc.close();

		}

				for (Hero h : heroesList) {
					System.out.println("--------------------------------------");
					System.out.println(h.toString());
					System.out.println("--------------------------------------");
				}






	}





}

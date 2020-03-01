import java.io.IOException;
import java.util.Scanner;

/**
 * Le rôle de cette classe est de lire un fichier 
 * au format markdown et de le traduire dans un 
 * autre format à l'aide d'un objet constructeur.
 * 
 * @author leberre
 *
 */
public class Directeur {

	private final Constructeur constructeur;
	
	/**
	 * Initialise un objet Directeur avec un constructeur.
	 * 
	 * @param constructeur un traducteur.
	 */
	public Directeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}
	
	/**
	 * Lit un fichier markdown et appelle un 
	 * objet constructeur sur chaque structure
	 * repérée.
	 * 
	 * @param scanner un objet permettant d'accéder au fichier ligne à ligne.
	 * @throws IOException si un problème 
	 */
	public void build(Scanner scanner) throws IOException {
		String line;		
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			String[] pieces = line.split(" ");
			switch(pieces[0]) {
				case "#":
					constructeur.buildHeader1(line.substring(2));
					break;
				case "##":
					constructeur.buildHeader2(line.substring(3));
					break;
				case "###":
					constructeur.buildHeader3(line.substring(4));
					break;
				case "":
					break;
				case "+" :
					constructeur.onBeginUnsortedList();
					constructeur.buildListItem(line.substring(2));
					line = scanner.nextLine();
					pieces = line.split(" ");

					while (pieces[0].equals("+")){
						constructeur.buildListItem(line.substring(2));
						if (scanner.hasNext() ){
							line = scanner.nextLine();
							pieces = line.split(" ");
						}
						else{
							break;
						}
					}
					constructeur.onEndUnsortedList();
					break;

				default :

					constructeur.onParagraphBegin();
					String[] str=line.split(" ");
					String res="";
					boolean ita=false;
					boolean bold=false;	
					for (String s:str){		
						if (s.contains("**")){
							if (!bold){
								constructeur.buildRawText(res);
								res=s.replace("**","");
							}
							else {
								res+=" "+s.replace("**","");
								constructeur.buildBold(res);
								res="";
							}
							bold=!bold;
						}
						else if (s.contains("*")){
							if (!ita){
								constructeur.buildRawText(res);
								res=s.replace("*","");
							}
							else {
								res+=" "+s.replace("*","");
								constructeur.buildItalic(res);
								res="";
							}
							ita=!ita;
						}
						else{
							if (res==""){
								res=s;
							}
							else{
								res=res+" "+s;
							}
						}
					
			}
			constructeur.buildRawText(res);
			constructeur.onParagraphEnd();
		}
	}
}
}

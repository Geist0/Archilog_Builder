
/**
 * Permet de construire une représentation HTML.
 * 
 * @author leberre
 *
 */
public class HTML implements Constructeur {
	StringBuilder stb = new StringBuilder();

	public HTML() {
		stb.append("<html>").append(System.lineSeparator()).append("<body>").append(System.lineSeparator()) ;
	}

	@Override

	public void onParagraphBegin() {
		stb.append("<p>") ;


	}

	@Override
	public void onParagraphEnd() {
		stb.append("</p>").append(System.lineSeparator()) ;
	}

	@Override
	public void buildHeader1(String s) {
		stb.append("<h1>").append(s).append("</h1>").append(System.lineSeparator());
	}

	@Override
	public void buildHeader2(String s) {
		stb.append("<h2>").append(s).append("</h2>").append(System.lineSeparator());
	}

	@Override
	public void buildHeader3(String s) {
		stb.append("<h3>").append(s).append("</h3>").append(System.lineSeparator());

	}

	@Override
	public void onBeginUnsortedList() {
		stb.append("<ul>").append(System.lineSeparator()) ;

	}

	@Override
	public void buildListItem(String s) {
		stb.append("<li>").append(s).append("</li>").append(System.lineSeparator());

	}

	@Override
	public void onEndUnsortedList() {
		stb.append("</ul>").append(System.lineSeparator()) ;

	}

	@Override
	public void buildRawText(String s) {
		stb.append(s) ;

	}

	@Override
	public void buildBold(String s) {
		stb.append(" ").append("<b>").append(s).append("</b>") ;

	}

	@Override
	public void buildItalic(String s) {
		stb.append(" ").append("<i>").append(s).append("</i>") ;

	}

	@Override
	public String getResult() {
		stb.append("</body>").append(System.lineSeparator()).append("</html>").append(System.lineSeparator()) ;
		return stb.toString();
	}

}

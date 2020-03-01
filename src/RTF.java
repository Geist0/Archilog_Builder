
/**
 * Permet de construire une représentation RTF.
 * 
 * @author leberre
 *
 */
public class RTF implements Constructeur {
	StringBuilder stb = new StringBuilder();
	@Override
	public void onParagraphBegin() {
		stb.append("{\\pard") ;

	}

	@Override
	public void onParagraphEnd() {
		stb.append("\\par}") ;

	}

	@Override
	public void buildHeader1(String s) {
		stb.append("{\\pard\\qc\\b\\fs40").append(s).append("\\par}") ;
	}

	@Override
	public void buildHeader2(String s) {
		stb.append("{\\pard\\qc\\b\\fs30").append(s).append("\\par}") ;

	}

	@Override
	public void buildHeader3(String s) {
		stb.append("{\\pard\\qc\\b\\fs20").append(s).append("\\par}") ;

	}

	@Override
	public void onBeginUnsortedList() {
		stb.append("\\line{\\pard\\li500\\ql");

	}

	@Override
	public void buildListItem(String s) {
		stb.append("{\\b * }").append(s).append("\\line");

	}

	@Override
	public void onEndUnsortedList() {
		stb.append("\\line\\par}");

	}

	@Override
	public void buildRawText(String s) {
		stb.append(s) ;

	}

	@Override
	public void buildBold(String s) {
		stb.append(" ").append("{\\b").append(s).append("}") ;

	}

	@Override
	public void buildItalic(String s) {
		stb.append(" ").append("{\\i").append(s).append("}") ;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return stb.toString() ;
	}

}

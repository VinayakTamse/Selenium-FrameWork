package selenium_app_feature.main.base;

public interface Css {
	
	String usernameCss = "input#txtUsername";
	String passwordCss = "input[name='txtPassword']";
	String loginButtonCss = "input[id= btnLogin]";
	String loginBtnId = "btnLogin";
	String newWindowCss = "button#windowButton";
	String newwindowmsgId = "messageWindowButton";
	
	static void hault()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}

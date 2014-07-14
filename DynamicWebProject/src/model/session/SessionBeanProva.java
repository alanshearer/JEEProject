package model.session;

import java.io.Serializable;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="SessionBeanProva")
@SessionScoped
public class SessionBeanProva implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1074236440616635971L;
	
	Integer randomInt;
	    Integer userNumber;
	    String response;
	    
	    public SessionBeanProva(){
	    	 Random randomGR = new Random();
	         randomInt = new Integer(randomGR.nextInt(10));
	         System.out.println("Duke's number: " + randomInt);
	    }
	    
	public Integer getUserNumber() {
			return userNumber;
		}

		public void setUserNumber(Integer userNumber) {
			this.userNumber = userNumber;
		}

	public String getResponse(){
	    if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {

		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        //session.invalidate();

        return "Yay! You got it!";
    } else {

        return "<p>Sorry, " + userNumber + " isn't it.</p>"
                + "<p>Guess again...</p>";
	}
	
}
}

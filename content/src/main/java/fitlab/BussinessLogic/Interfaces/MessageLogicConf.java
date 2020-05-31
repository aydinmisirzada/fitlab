package fitlab.BussinessLogic.Interfaces;

/**
 * Interface for chat messages
 */
public interface MessageLogicConf {
     /**
      * The method adds a message to the page
      * @param subject This is an object of the subject which has a content page
      * @param type This is the type of the content page (homework,test,exam)
      * @param page_id This is id of the page
      * @param author This is the name of writer
      * @param text This is the text
      */
     void pageAddMessage( String subject,String type, int page_id, String author, String text);

}

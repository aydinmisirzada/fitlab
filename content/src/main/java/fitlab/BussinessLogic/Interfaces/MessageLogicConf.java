package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.Message;

/**
 * Interface for chat messages
 */
public interface MessageLogicConf {
     /**
      * The method adds a message to the page
      * @param page_id This is id of the page
      * @param author This is the name of writer
      * @param text This is the text
      */
     void pageAddMessage( int page_id, String author, String text);
     void delMessage (Message mes);
}

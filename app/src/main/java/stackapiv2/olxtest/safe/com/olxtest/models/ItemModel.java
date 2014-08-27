package stackapiv2.olxtest.safe.com.olxtest.models;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public class ItemModel extends BaseModel{
    public String title = DEFAULT_STRING;
    public String question_id = DEFAULT_STRING;
    public String link = DEFAULT_STRING;
    public OwnerModel owner = new OwnerModel();
}

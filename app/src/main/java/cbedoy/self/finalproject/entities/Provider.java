package cbedoy.self.finalproject.entities;

import com.orm.SugarRecord;

/**
 * Created by Carlos Bedoy on 6/18/15.
 * <p/>
 * Mobile App Developer - Exchange Android
 * <p/>
 * Pademobile
 */
public class Provider extends SugarRecord<Provider>
{
    public String name;
    public float latitude;
    public float longitude;
    public String description;
}

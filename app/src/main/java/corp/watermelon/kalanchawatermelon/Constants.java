package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 09.02.2017.
 */

public class Constants {

    static final String ROW_ID="id";
    static final String NAME = "name";
    static final String MUD = "mud";

    static final String DB_NAME="b_DB";
    static final String TB_NAME="b_TB";
    static final int DB_VERSION='1';

    static final String CREATE_TB="CREATE TABLE b_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,mud TEXT NOT NULL);";
}

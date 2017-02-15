package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 09.02.2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DbHelper helper;

    public DBAdapter(Context ctx)
    {
        this.c=ctx;
        helper=new DbHelper(c);
    }


    public DBAdapter openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return this;
    }

    public void close()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public long add(String name,String pos)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME,name);
            cv.put(Constants.MUD, pos);
            return db.insert(Constants.TB_NAME,Constants.ROW_ID,cv);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public Cursor getAllFruits()
    {
        String[] columns={Constants.ROW_ID,Constants.NAME,Constants.MUD};
        return db.query(Constants.TB_NAME,columns,null,null,null,null,null);
    }


    public long UPDATE(int id,String name,String pos)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME,name);
            cv.put(Constants.MUD, pos);
            return db.update(Constants.TB_NAME,cv,Constants.ROW_ID+" =?",new String[]{String.valueOf(id)});
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }


    public long Delete(int id)
    {
        try
        {
            return db.delete(Constants.TB_NAME,Constants.ROW_ID+" =?",new String[]{String.valueOf(id)});
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}

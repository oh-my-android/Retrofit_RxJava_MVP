package com.example.y.mvp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.y.mvp.NewsDetailInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEWS_DETAIL_INFO".
*/
public class NewsDetailInfoDao extends AbstractDao<NewsDetailInfo, Void> {

    public static final String TABLENAME = "NEWS_DETAIL_INFO";

    /**
     * Properties of entity NewsDetailInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Integer.class, "id", false, "ID");
        public final static Property Count = new Property(1, Integer.class, "count", false, "COUNT");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Fcount = new Property(3, Integer.class, "fcount", false, "FCOUNT");
        public final static Property Fromname = new Property(4, String.class, "fromname", false, "FROMNAME");
        public final static Property Img = new Property(5, String.class, "img", false, "IMG");
        public final static Property Keywords = new Property(6, String.class, "keywords", false, "KEYWORDS");
        public final static Property Message = new Property(7, String.class, "message", false, "MESSAGE");
        public final static Property Rcount = new Property(8, Integer.class, "rcount", false, "RCOUNT");
        public final static Property Title = new Property(9, String.class, "title", false, "TITLE");
        public final static Property Topclass = new Property(10, Integer.class, "topclass", false, "TOPCLASS");
        public final static Property Fromurl = new Property(11, String.class, "fromurl", false, "FROMURL");
        public final static Property Time = new Property(12, Long.class, "time", false, "TIME");
    };


    public NewsDetailInfoDao(DaoConfig config) {
        super(config);
    }
    
    public NewsDetailInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEWS_DETAIL_INFO\" (" + //
                "\"ID\" INTEGER," + // 0: id
                "\"COUNT\" INTEGER," + // 1: count
                "\"DESCRIPTION\" TEXT," + // 2: description
                "\"FCOUNT\" INTEGER," + // 3: fcount
                "\"FROMNAME\" TEXT," + // 4: fromname
                "\"IMG\" TEXT," + // 5: img
                "\"KEYWORDS\" TEXT," + // 6: keywords
                "\"MESSAGE\" TEXT," + // 7: message
                "\"RCOUNT\" INTEGER," + // 8: rcount
                "\"TITLE\" TEXT," + // 9: title
                "\"TOPCLASS\" INTEGER," + // 10: topclass
                "\"FROMURL\" TEXT," + // 11: fromurl
                "\"TIME\" INTEGER);"); // 12: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEWS_DETAIL_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, NewsDetailInfo entity) {
        stmt.clearBindings();
 
        Integer id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer count = entity.getCount();
        if (count != null) {
            stmt.bindLong(2, count);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
 
        Integer fcount = entity.getFcount();
        if (fcount != null) {
            stmt.bindLong(4, fcount);
        }
 
        String fromname = entity.getFromname();
        if (fromname != null) {
            stmt.bindString(5, fromname);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(6, img);
        }
 
        String keywords = entity.getKeywords();
        if (keywords != null) {
            stmt.bindString(7, keywords);
        }
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(8, message);
        }
 
        Integer rcount = entity.getRcount();
        if (rcount != null) {
            stmt.bindLong(9, rcount);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(10, title);
        }
 
        Integer topclass = entity.getTopclass();
        if (topclass != null) {
            stmt.bindLong(11, topclass);
        }
 
        String fromurl = entity.getFromurl();
        if (fromurl != null) {
            stmt.bindString(12, fromurl);
        }
 
        Long time = entity.getTime();
        if (time != null) {
            stmt.bindLong(13, time);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public NewsDetailInfo readEntity(Cursor cursor, int offset) {
        NewsDetailInfo entity = new NewsDetailInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // count
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // fcount
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // fromname
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // img
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // keywords
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // message
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // rcount
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // title
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // topclass
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // fromurl
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12) // time
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, NewsDetailInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setCount(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFcount(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setFromname(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setImg(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setKeywords(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMessage(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRcount(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setTitle(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTopclass(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setFromurl(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setTime(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(NewsDetailInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(NewsDetailInfo entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
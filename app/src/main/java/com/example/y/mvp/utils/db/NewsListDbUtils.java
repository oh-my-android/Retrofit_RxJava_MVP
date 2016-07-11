package com.example.y.mvp.utils.db;

import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.NewsListInfoDao;

import java.util.List;

/**
 * by 12406 on 2016/7/9.
 */
public class NewsListDbUtils {

    public static void addNewsList(int id, int type, String title, String img, String fromurl, Long time) {
        if (searchNewsList(id)) {
            GreenDaoDbUtils.getNewsListInfoDb().insert(new NewsListInfo(id, type, null, null, null, null, title, img, fromurl, time, null));
        }
    }

    public static void deleteNewsList() {
        GreenDaoDbUtils.getNewsListInfoDb().deleteAll();
    }

    public static List<NewsListInfo> getNewsList() {
        return GreenDaoDbUtils.getNewsListInfoDb().loadAll();
    }

    public static boolean searchNewsList(int id) {
        return GreenDaoDbUtils.getNewsListInfoDb().queryBuilder().where(NewsListInfoDao.Properties.Id.eq(id)).unique() == null;
    }

}
package ru.parshikov.myfirstapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.parshikov.myfirstapp.db.PostContract.Columns

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "myfirstapp.db"
        private const val DATABASE_VERSION = 1

        // SQL для создания таблицы
        private const val  SQL_CREATE_POSTS =
            "CREATE TABLE ${PostContract.TABLE_NAME} (" +
                    "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.AUTHOR} TEXT NOT NULL," +
                    "${Columns.AUTHOR_ID} INTEGER NOT NULL," +
                    "${Columns.CONTENT} TEXT NOT NULL," +
                    "${Columns.PUBLISHED} TEXT NOT NULL," +
                    "${Columns.LIKED_BY_ME} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.LIKES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.SHARES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIEWS} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIDEO} TEXT" +
                    ")"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Создаем таблицу при первом запуске
        db.execSQL(SQL_CREATE_POSTS)

        // Здесь можно добавить начальные данные
        insertInitialData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // При обновлении версии удаляем старую таблицу и создаем новую
        // В реальном проекте здесь должна быть миграция данных
        db.execSQL("DROP TABLE IF EXISTS ${PostContract.TABLE_NAME}")
        onCreate(db)
    }

    private fun insertInitialData(db: SQLiteDatabase) {
        // Пост 1: "Новости Без Границ"
            android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Новости Без Границ")
            put(Columns.AUTHOR_ID, 2)
            put(Columns.CONTENT, "За последнюю неделю Роскомнадзор продолжил выявлять и блокировать ресурсы, нарушающие российское законодательство. Среди них — популярные сайты и сервисы, связанные с обходом блокировок и распространением запрещенной информации. Эти меры направлены на усиление контроля за контентом в сети и обеспечение безопасности пользователей.")
            put(Columns.PUBLISHED, "21 мая в 18:36")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 999)
            put(Columns.SHARES, 25)
            put(Columns.VIEWS, 599)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 2: "Цифровой Надзор" (с видео)
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Цифровой Надзор")
            put(Columns.AUTHOR_ID, 3)
            put(Columns.CONTENT, "Роскомнадзор внес в реестр запрещенных информационных ресурсов группу доменов и IP-адресов, принадлежащих крупному зарубежному VPN-сервису. Основанием для блокировки стало предоставление неограниченного доступа к контенту, запрещенному на территории Российской Федерации, а также игнорирование требований о подключении к государственной информационной системе (ГИС). Эксперты отмечают, что точечные блокировки серверов значительно усложнили работу сервисов обхода блокировок в ряде регионов страны.")
            put(Columns.PUBLISHED, "22 мая в 10:15")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 342)
            put(Columns.SHARES, 89)
            put(Columns.VIEWS, 2300)
            put(Columns.VIDEO, "https://www.youtube.com/watch?v=WhWc3b3KhnY")
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 3: "Интернет-Вестник"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Интернет-Вестник")
            put(Columns.AUTHOR_ID, 4)
            put(Columns.CONTENT, "По решению Генеральной прокуратуры, Роскомнадзор приступил к замедлению трафика на территории РФ в отношении популярной международной социальной платформы. Ведомство зафиксировало неоднократные случаи размещения материалов с призывами к участию в несанкционированных мероприятиях и распространение недостоверной информации общественно значимого характера. Администрация ресурса не назначила официального представителя в России, что послужило дополнительным основанием для применения мер принудительного исполнения законодательства о защите информации.")
            put(Columns.PUBLISHED, "23 мая в 09:42")
            put(Columns.LIKED_BY_ME, 1)
            put(Columns.LIKES, 1250)
            put(Columns.SHARES, 420)
            put(Columns.VIEWS, 8900)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 4: "Мониторинг Сети"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Мониторинг Сети")
            put(Columns.AUTHOR_ID, 5)
            put(Columns.CONTENT, "В ходе совместной работы с МВД России Роскомнадзор заблокировал серию интернет-ресурсов и Telegram-каналов, специализировавшихся на незаконной торговле персональными данными граждан. Доступ к ресурсам, на которых предлагались базы данных паспортов и СНИЛС, ограничен на постоянной основе. Ведомство напоминает, что за утечку и незаконный оборот персональных данных законодательством предусмотрена как административная, так и уголовная ответственность. Операторам связи направлены уведомления о необходимости незамедлительного ограничения доступа к указанным источникам.")
            put(Columns.PUBLISHED, "20 мая в 20:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 5678)
            put(Columns.SHARES, 1234)
            put(Columns.VIEWS, 45000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 5: "Цензор Онлайн" (с видео)
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Цензор Онлайн")
            put(Columns.AUTHOR_ID, 6)
            put(Columns.CONTENT, "Роскомнадзор усилил контроль за распространением фейковых новостей и дезинформации в социальных сетях. За прошедший месяц было заблокировано более 200 аккаунтов, распространявших недостоверную информацию, которая могла повлиять на общественное мнение и безопасность.")
            put(Columns.PUBLISHED, "24 мая в 14:20")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 1430)
            put(Columns.SHARES, 300)
            put(Columns.VIEWS, 12000)
            put(Columns.VIDEO, "https://www.youtube.com/watch?v=WhWc3b3KhnY")
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 6: "Технологии и Закон"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Технологии и Закон")
            put(Columns.AUTHOR_ID, 7)
            put(Columns.CONTENT, "На основании новых поправок в законодательство, Роскомнадзор получил право требовать от интернет-компаний предоставления более подробной информации о пользователях при подозрении на нарушение законов Российской Федерации, включая нарушение правил распространения контента.")
            put(Columns.PUBLISHED, "24 мая в 17:45")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 980)
            put(Columns.SHARES, 210)
            put(Columns.VIEWS, 6700)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 7: "Вести Интернет"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Вести Интернет")
            put(Columns.AUTHOR_ID, 8)
            put(Columns.CONTENT, "В рамках проведения профилактических мероприятий Роскомнадзор совместно с Минкомсвязью провел обход популярных мессенджеров и выявил ряд каналов, распространяющих запрещённый контент и призывы к нарушениям закона.")
            put(Columns.PUBLISHED, "25 мая в 11:30")
            put(Columns.LIKED_BY_ME, 1)
            put(Columns.LIKES, 2560)
            put(Columns.SHARES, 580)
            put(Columns.VIEWS, 34000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 8: "РосИнформ"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "РосИнформ")
            put(Columns.AUTHOR_ID, 9)
            put(Columns.CONTENT, "Новая инициатива Роскомнадзора предусматривает создание центра мониторинга онлайн-активности для оперативного выявления и блокировки ресурсов, нарушающих законодательство в сфере защиты персональных данных и национальной безопасности.")
            put(Columns.PUBLISHED, "25 мая в 15:10")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 760)
            put(Columns.SHARES, 150)
            put(Columns.VIEWS, 9500)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 9: "Новости Без Границ"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Новости Без Границ")
            put(Columns.AUTHOR_ID, 10)
            put(Columns.CONTENT, "Роскомнадзор сообщил о блокировке нескольких зарубежных сервисов, которые предоставляли доступ к пиратскому контенту, нарушая авторские права российских правообладателей. Ведомство продолжит активную борьбу с нелегальными ресурсами.")
            put(Columns.PUBLISHED, "26 мая в 09:55")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 1980)
            put(Columns.SHARES, 430)
            put(Columns.VIEWS, 21000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        // Пост 10: "Интернет Контроль"
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Интернет Контроль")
            put(Columns.AUTHOR_ID, 11)
            put(Columns.CONTENT, "В результате сотрудничества с крупными операторами связи Роскомнадзор добился снижения трафика на подозрительных ресурсах, что существенно затруднило их деятельность и ограничило распространение вредоносного контента.")
            put(Columns.PUBLISHED, "26 мая в 13:40")
            put(Columns.LIKED_BY_ME, 1)
            put(Columns.LIKES, 1300)
            put(Columns.SHARES, 320)
            put(Columns.VIEWS, 16500)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

    }
}

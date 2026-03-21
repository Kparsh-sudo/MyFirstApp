package ru.parshikov.myfirstapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.parshikov.myfirstapp.dto.Post
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class PostRepositoryInMemoryImpl : PostRepository {

    // Счетчик для генерации ID
    private var nextId = 5L

    // Текущий пользователь (для демонстрации)
    private val currentUserId = 1L
    private val currentUserName = "Я"


    private var posts = listOf(
        Post(
            id = 1,
            authorId = 2,
            author = "Новости Без Границ",
            content = "За последнюю неделю Роскомнадзор продолжил выявлять и блокировать ресурсы, нарушающие российское законодательство. Среди них — популярные сайты и сервисы, связанные с обходом блокировок и распространением запрещенной информации. Эти меры направлены на усиление контроля за контентом в сети и обеспечение безопасности пользователей.",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999,
            shares = 25,
            views = 599
        ),
        Post(
            id = 2,
            authorId = 3,
            author = "Цифровой Надзор",
            content = "Роскомнадзор внес в реестр запрещенных информационных ресурсов группу доменов и IP-адресов, принадлежащих крупному зарубежному VPN-сервису. Основанием для блокировки стало предоставление неограниченного доступа к контенту, запрещенному на территории Российской Федерации, а также игнорирование требований о подключении к государственной информационной системе (ГИС). Эксперты отмечают, что точечные блокировки серверов значительно усложнили работу сервисов обхода блокировок в ряде регионов страны.",
            published = "22 мая в 10:15",
            likedByMe = false,
            likes = 342,
            shares = 89,
            views = 2300
        ),
        Post(
            id = 3,
            authorId = 4,
            author = "Интернет-Вестник",
            content = "По решению Генеральной прокуратуры, Роскомнадзор приступил к замедлению трафика на территории РФ в отношении популярной международной социальной платформы. Ведомство зафиксировало неоднократные случаи размещения материалов с призывами к участию в несанкционированных мероприятиях и распространение недостоверной информации общественно значимого характера. Администрация ресурса не назначила официального представителя в России, что послужило дополнительным основанием для применения мер принудительного исполнения законодательства о защите информации."
            ,
            published = "23 мая в 09:42",
            likedByMe = true,
            likes = 1250,
            shares = 420,
            views = 8900
        ),
        Post(
            id = 4,
            authorId = 5,
            author = "Мониторинг Сети",
            content = "В ходе совместной работы с МВД России Роскомнадзор заблокировал серию интернет-ресурсов и Telegram-каналов, специализировавшихся на незаконной торговле персональными данными граждан. Доступ к ресурсам, на которых предлагались базы данных паспортов и СНИЛС, ограничен на постоянной основе. Ведомство напоминает, что за утечку и незаконный оборот персональных данных законодательством предусмотрена как административная, так и уголовная ответственность. Операторам связи направлены уведомления о необходимости незамедлительного ограничения доступа к указанным источникам.",
            published = "20 мая в 20:00",
            likedByMe = false,
            likes = 5678,
            shares = 1234,
            views = 45000
        ),
        Post(
            id = 5,
            authorId = 6,
            author = "Цензор Онлайн",
            content = "Роскомнадзор усилил контроль за распространением фейковых новостей и дезинформации в социальных сетях. За прошедший месяц было заблокировано более 200 аккаунтов, распространявших недостоверную информацию, которая могла повлиять на общественное мнение и безопасность.",
            published = "24 мая в 14:20",
            likedByMe = false,
            likes = 1430,
            shares = 300,
            views = 12000
        ),
        Post(
            id = 6,
            authorId = 7,
            author = "Технологии и Закон",
            content = "На основании новых поправок в законодательство, Роскомнадзор получил право требовать от интернет-компаний предоставления более подробной информации о пользователях при подозрении на нарушение законов Российской Федерации, включая нарушение правил распространения контента.",
            published = "24 мая в 17:45",
            likedByMe = false,
            likes = 980,
            shares = 210,
            views = 6700
        ),
        Post(
            id = 7,
            authorId = 8,
            author = "Вести Интернет",
            content = "В рамках проведения профилактических мероприятий Роскомнадзор совместно с Минкомсвязью провел обход популярных мессенджеров и выявил ряд каналов, распространяющих запрещённый контент и призывы к нарушениям закона.",
            published = "25 мая в 11:30",
            likedByMe = true,
            likes = 2560,
            shares = 580,
            views = 34000
        ),
        Post(
            id = 8,
            authorId = 9,
            author = "РосИнформ",
            content = "Новая инициатива Роскомнадзора предусматривает создание центра мониторинга онлайн-активности для оперативного выявления и блокировки ресурсов, нарушающих законодательство в сфере защиты персональных данных и национальной безопасности.",
            published = "25 мая в 15:10",
            likedByMe = false,
            likes = 760,
            shares = 150,
            views = 9500
        ),
        Post(
            id = 9,
            authorId = 10,
            author = "Новости Без Границ",
            content = "Роскомнадзор сообщил о блокировке нескольких зарубежных сервисов, которые предоставляли доступ к пиратскому контенту, нарушая авторские права российских правообладателей. Ведомство продолжит активную борьбу с нелегальными ресурсами.",
            published = "26 мая в 09:55",
            likedByMe = false,
            likes = 1980,
            shares = 430,
            views = 21000
        ),
        Post(
            id = 10,
            authorId = 11,
            author = "Интернет Контроль",
            content = "В результате сотрудничества с крупными операторами связи Роскомнадзор добился снижения трафика на подозрительных ресурсах, что существенно затруднило их деятельность и ограничило распространение вредоносного контента.",
            published = "26 мая в 13:40",
            likedByMe = true,
            likes = 1300,
            shares = 320,
            views = 16500
        )
    )



    private val _data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = _data

    override fun likeById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun shareById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(shares = post.shares + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun increaseViews(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(views = post.views + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun save(post: Post) {
        if (post.id == 0L) {
            // Создание нового поста
            val newPost = post.copy(
                id = nextId++,
                author = currentUserName,
                authorId = currentUserId,
                published = formatDate(Date()),
                likedByMe = false,
                likes = 0,
                shares = 0,
                views = 0
            )
            posts = listOf(newPost) + posts
        } else {
            // Обновление существующего поста
            posts = posts.map { existingPost ->
                if (existingPost.id == post.id) {
                    // Сохраняем автора, дату и счетчики, обновляем только контент
                    existingPost.copy(content = post.content)
                } else {
                    existingPost
                }
            }
        }
        _data.value = posts
    }

    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        _data.value = posts
    }

    private fun formatDate(date: Date): String {
        val format = SimpleDateFormat("d MMM в HH:mm", Locale("ru"))
        return format.format(date)
    }
}

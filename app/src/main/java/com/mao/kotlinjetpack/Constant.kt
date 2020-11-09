// 注解 定义文件生成类的名字
@file:JvmName("Constant")
package com.mao.kotlinjetpack

/**
 *
 * @author zhangkun
 * @time 2020/11/9 2:17 PM
 * @Description 定义常量类型  Java 调用时 Constant.EXTRA_PHOTO  Kotlin 调用时 EXTRA_PHOTO
 */

// 顶层常量
const val EXTRA_PHOTO = "photo"

const val CACHE_RESPONSE =
    "{\"login\":\"JakeWharton\",\"id\":66577,\"node_id\":\"MDQ6VXNlcjY2NTc3\",\"avatar_url\":\"https://avatars0.githubusercontent.com/u/66577?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/JakeWharton\",\"html_url\":\"https://github.com/JakeWharton\",\"followers_url\":\"https://api.github.com/users/JakeWharton/followers\",\"following_url\":\"https://api.github.com/users/JakeWharton/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/JakeWharton/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/JakeWharton/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/JakeWharton/subscriptions\",\"organizations_url\":\"https://api.github.com/users/JakeWharton/orgs\",\"repos_url\":\"https://api.github.com/users/JakeWharton/repos\",\"events_url\":\"https://api.github.com/users/JakeWharton/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/JakeWharton/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Jake Wharton\",\"company\":\"Square\",\"blog\":\"https://jakewharton.com\",\"location\":\"Pittsburgh, PA, USA\",\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":104,\"public_gists\":54,\"followers\":57849,\"following\":12,\"created_at\":\"2009-03-24T16:09:53Z\",\"updated_at\":\"2020-05-28T00:07:20Z\"}"

const val CACHE_RESPONSE_2 = """{"login":"JakeWharton",
        "id":66577,
        "node_id":"MDQ6VXNlcjY2NTc3",
        "avatar_url":"https://avatars0.githubusercontent.com/u/66577?v=4",
        "gravatar_id":"","url":"https://api.github.com/users/JakeWharton",
        "html_url":"https://github.com/JakeWharton",
        "followers_url":"https://api.github.com/users/JakeWharton/followers",
        "following_url":"https://api.github.com/users/JakeWharton/following{/other_user}",
        "gists_url":"https://api.github.com/users/JakeWharton/gists{/gist_id}",
        "starred_url":"https://api.github.com/users/JakeWharton/starred{/owner}{/repo}",
        "subscriptions_url":"https://api.github.com/users/JakeWharton/subscriptions",
        "organizations_url":"https://api.github.com/users/JakeWharton/orgs",
        "repos_url":"https://api.github.com/users/JakeWharton/repos",
        "events_url":"https://api.github.com/users/JakeWharton/events{/privacy}",
        "received_events_url":"https://api.github.com/users/JakeWharton/received_events",
        "type":"User",
        "site_admin":false,"name":"Jake Wharton",
        "company":"Square",
        "blog":"https://jakewharton.com",
        "location":"Pittsburgh, PA, USA",
        "email":null,
        "hireable":null,
        "bio":null,
        "twitter_username":null,
        "public_repos":104,
        "public_gists":54,
        "followers":57849,
        "following":12,
        "created_at":"2009-03-24T16:09:53Z",
        "updated_at":"2020-05-28T00:07:20Z"}
        """
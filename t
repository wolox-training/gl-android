[1mdiff --git a/app/src/main/java/ar/com/wolox/android/example/ui/home/news/NewsPresenter.kt b/app/src/main/java/ar/com/wolox/android/example/ui/home/news/NewsPresenter.kt[m
[1mindex 96c3952..957ca15 100644[m
[1m--- a/app/src/main/java/ar/com/wolox/android/example/ui/home/news/NewsPresenter.kt[m
[1m+++ b/app/src/main/java/ar/com/wolox/android/example/ui/home/news/NewsPresenter.kt[m
[36m@@ -75,7 +75,8 @@[m [mclass NewsPresenter @Inject constructor(private val monitorServices: RetrofitSer[m
                 view.showNews(listNews)[m
                 isLoading = false[m
             }[m
[31m-        })[m
[32m+[m[32m        }l code[m
[32m+[m
     }[m
 [m
     internal fun getUserId(context: Context): Int {[m

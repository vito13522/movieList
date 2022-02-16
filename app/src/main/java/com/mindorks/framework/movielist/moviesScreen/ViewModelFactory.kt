package com.mindorks.framework.movielist.moviesScreen

//class ViewModelFactory (
//    app: Application,
//) : ViewModelProvider.Factory {
//
//
//    private val daoMovie = ApiInterface.create()
//
//    private var repository = Repository( daoMovie)
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when (true) {
//
//            modelClass.isAssignableFrom(MoviesViewModel::class.java) ->
//                MoviesViewModel(this.repository) as T
//            else -> throw IllegalArgumentException("ViewModel Not Found")
//
//        }
//    }
//}
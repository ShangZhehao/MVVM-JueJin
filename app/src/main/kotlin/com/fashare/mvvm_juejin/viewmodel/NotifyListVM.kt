package com.fashare.mvvm_juejin.viewmodel

import com.fashare.databinding.TwoWayListVM
import com.fashare.databinding.adapters.annotation.HeaderResHolder
import com.fashare.databinding.adapters.annotation.ResHolder
import com.fashare.mvvm_juejin.R
import com.fashare.mvvm_juejin.model.notify.NotifyBean
import com.fashare.mvvm_juejin.repo.Composers
import com.fashare.mvvm_juejin.repo.JueJinApis
import com.fashare.mvvm_juejin.view.detail.ArticleActivity
import com.fashare.net.ApiFactory

/**
 * <pre>
 * author : jinliangshan
 * e-mail : 153614131@qq.com
 * desc   :
</pre> *
 */

@ResHolder(R.layout.item_notify_list)
@HeaderResHolder(R.layout.header_notify)
class NotifyListVM : TwoWayListVM<NotifyBean>() {
    override val loadTask = { lastItem: NotifyBean? ->
        ApiFactory.getApi(JueJinApis.Notify:: class.java)
            .getUserNotification(lastItem?.createdAtString?: "")
            .compose(Composers.handleError())
    }
    override val onItemClick = ArticleActivity.START_FROM_NOTIFY
    override val headerData = Any()
}

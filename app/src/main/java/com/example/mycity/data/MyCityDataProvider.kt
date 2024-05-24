package com.example.mycity.data

import androidx.annotation.StringRes
import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Outlet

object MyCityDataProvider {
    val categories = listOf(
        Category(
            name = R.string.coffee_shops,
            thumbnail = R.drawable.coffee_shop_1,
            recommendations = listOf(
                Outlet(
                    name = R.string.java_jive,
                    image = R.drawable.img_20180505_wa0005_largejpg,
                    category = R.string.coffee_shops,
                    content = R.string.java_jive_content,
                    selected = true
                ),
                Outlet(
                    name = R.string.brew_haven,
                    image = R.drawable.coffee_shop_2,
                    category = R.string.coffee_shops,
                    content = R.string.brew_haven_content,
                ),
                Outlet(
                    name = R.string.cosmic_cup,
                    image = R.drawable.pasteries_inside_la_baguette,
                    category = R.string.coffee_shops,
                    content = R.string.cosmic_cup_content,
                )
            ),
            selected = true
        ),
        Category(
            name = R.string.restaurants,
            thumbnail = R.drawable.market_770_restaurant_4_min,
            recommendations = listOf(
                Outlet(
                    name = R.string.culinary_creations,
                    image = R.drawable.encuentranos_en_av_javier,
                    category = R.string.restaurants,
                    content = R.string.culinary_creations_content,
                ),
                Outlet(
                    name = R.string.time_warp,
                    image = R.drawable.market_770_restaurant_4_min,
                    category = R.string.restaurants,
                    content = R.string.time_warp_content,
                ),
                Outlet(
                    name = R.string.sakura_heaven,
                    image = R.drawable.la_plaza_bar_grill,
                    category = R.string.restaurants,
                    content = R.string.sakura_heaven_content,
                )
            )
        ),

        Category(
            name = R.string.shopping_centres,
            thumbnail = R.drawable.shopping_centre1,
            recommendations = listOf(
                Outlet(
                    name = R.string.avenue_central_park,
                    image = R.drawable.plaza_san_miguel,
                    category = R.string.shopping_centres,
                    content = R.string.avenue_central_park_content
                ),
                Outlet(
                    name = R.string.hilltop_emporium,
                    image = R.drawable.pe_edificacion_y_vivienda_2016_mall_del_sur_01_16_9,
                    category = R.string.shopping_centres,
                    content = R.string.hilltop_emporium_content
                ),
                Outlet(
                    name = R.string.harbor_point_marketplace,
                    image = R.drawable.delfines_hotel_peru_lima_lugares_turisticos_centro_comercial_larcomar_miraflores_standard,
                    category = R.string.shopping_centres,
                    content = R.string.harbor_point_marketplace_content
                )
            )
        ),

    )

    private var activeCategory: Category? = categories[0]

    fun selectActiveCategory(@StringRes categoryId: Int){
        if(activeCategory?.name != categoryId)
            activeCategory?.selected = false

        activeCategory = categories.find { category -> category.name == categoryId }
        activeCategory?.selected = true
    }

    private var activeOutlet: Outlet? = categories[0].recommendations[0]

    fun selectActiveOutlet(@StringRes outletId: Int){
        if(activeOutlet?.name != outletId)
            activeOutlet?.selected = false

        activeOutlet = activeCategory?.recommendations?.find{outlet -> outlet.name == outletId }
        activeOutlet?.selected = true
    }
}
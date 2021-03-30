package com.example

case class WineProfile(
                        id: Int,
                        country: Option[String],
                        points: Option[Int],
                        price: Option[Double],
                        title: Option[String],
                        variety: Option[String],
                        winery: Option[String]
                      )

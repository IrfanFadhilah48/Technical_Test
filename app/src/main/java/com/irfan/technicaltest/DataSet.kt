package com.irfan.technicaltest

object DataSet {
    private val namaImage = arrayOf(
        "Gambar 1",
        "Gambar 2",
        "Gambar 3",
        "Gambar 4",
        "Gambar 5",
        "Gambar 6",
        "Gambar 7",
        "Gambar 8",
        "Gambar 9",
        "Gambar 10"
    )

    private val imageData = intArrayOf(
        R.drawable.mancheste_united,
        R.drawable.barcelona,
        R.drawable.bayern_munich,
        R.drawable.chelsea,
        R.drawable.real_madrid,
        R.drawable.inter_milan,
        R.drawable.lazio,
        R.drawable.liverpool,
        R.drawable.sheffield_united,
        R.drawable.borussia
    )

    val groupData: ArrayList<ImageModel>
        get() {
            val listData = arrayListOf<ImageModel>()
            for (position in imageData.indices){
                val data = ImageModel()
                data.namaImage = namaImage[position]
                data.image = imageData[position]
                listData.add(data)
            }
            return listData
        }
}
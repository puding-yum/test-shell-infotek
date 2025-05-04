#### Optimistic Locking
optimistic locking merupakan pengaturan ketika terjadi 2 atau lebih perubahan di satu row data yang sama.
contohnya ada banyak user melakukan update data yang sama. 
pengaturan optimistic locking tidak mengunci data yang sedang dirubah oleh suatu user.
jadi misal 2 user mengurangi quantity produk yang sama dan di waktu bersamaan, bisa jadi data hanya berubah dengan data 1 user.
untuk menghindarinya bisa dilakukan row lock
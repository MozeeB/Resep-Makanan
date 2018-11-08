package com.example.mozeeb.resepmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //String[] judul, bahan, membuat;

    String [][] data = {{"Nasi Goreng",
            "Bahan :\n\n1.Nasi 600 gr\n2.Daging ayam 125 g. Cincang halus\n3.Telur 1 butir. Kocok\n4.Bawang merah 5 siung\n5.bawang putih 3 siung\n6.Cabai merah 3 buah\n7.Daun bawang 1 batang. Iris halus\n8.Kecap manis 2 sdm\n9.Garam 1 sdt\n10.Merica sdt\n11.Minyak",
            "Cara Membuat :\n\n1.Masukkan bawang merah, bawang putih, dan cabai merah ke dalam cobek kemudian haluskan\n\n2.Goreng telur menjadi orak-arik lalu sisihkan\n\n3.Bumbu yang telah dihaluskan kemudian di tumis dengan minyak secukupnya. Tumis terus hingga harum\n\n4.Masukkan ayam cincang, telur, dan daun bawang ke dalam bumbu. Tumis lagi hingga merata\n\n5.Tambahkan kecap, garam, dan merica. Aduk hingga rata\n\n6.Baru kemudian masukkan nasi dan aduk hingga rata\n\n7.Nasi goreng telah jadi dan sajikan pada piring saji"},
            {"Mie Ayam",
                    "Bahan :\n\n1.Mie basah atau mie telor 500 g\n2.daging ayam 300 g\n3.Minyak ayam 500 ml\n4.Bawang putih 4 siung\n5.Bawang merah 4 buah\n6.Ketumbar 1 sdt\n7.Kunyit seruas jari\n8.Kemiri 4 butir\n9.Jahe 1 ruas\n10.Lada bubuk sdt\n11.Garam 1 sdt\n12.Tulang ayam secukupnya",
                    "Cara Membuat :\n\n1.Pertama, kita akan membuat kuah kaldu mie ayam terlebih dahulu, yaitu dengan merebus lagi air rebusan daging ayam ditambahkan dengan lada bubuk, garam, dan tulang ayam secukupnya\n\n2.Kedua, membuat toping ayam. Ayam yang telah direbus kemudian di potong kecil-kecil atau potong halus\n\n3.Haluskan bumbu yang terdiri dari bawang putih, bawang merah, ketumbar, kunyit, kemiri, dan jahe\n\n4.Tumis ayam dengan bumbu yang telah dihaluskan\n\n5.Tambahkan garam dan penyedap rasa secukupnya\n\n6.Setelah kuah mie ayam dan toping ayam, kita beranjak pada mie ayam. Rebus mie basah atau mie telur hingga matang\n\n7.Selama merebus mie, siapkan mangkuk. Kemudian tambahkan 1 sdm minyak ayam dan sdt merica\n\n8.Masukkan mie yang telah matang ke dalam mangkuk. Kemudian aduk mie hingga tercampur sempurna dengan minyak ayam\n\n9.Tambahan toping ayam dan juga kuah ayam\n\n10.Mie ayam siap disajikan"},
            {"Bakso Daging Ayam",
                    "Bahan :\n\n1.Daging ayam 1 kg, tanpa tulang, giling\n2.Tepung kanji 50 g\n3.Telur 1 butir\n4.Lada bubuk sdt\n5.Garam 1 sdt\n6.Bawang putih 4 siung, haluskan\n7.Bawang merah goreng 2 sdm\n8.Es batu 40 g, hancurkan\n9.Air 2 L",
                    "Cara Membuat :\n\n1.Masukkan daging ayam yang telah digiling ke dalam wadah, campurkan tepung kanji, telur, lada bubuk, garam, bawang putih yang telah dihaluskan dan bawang merah goreng. Campur atau uleni dengan tangan atau bisa menggunakan alat sampai semua tercampur sempurna\n\n2.Jika dirasa adonan masih lembek dan sulit dibentuk, maka bisa ditambahkan es batu secara perlahan sampai dirasa adonan bisa dibentuk\n\n3.Rebus air dalam panci sampai mendidih\n\n4.Ambil adonan daging dengan tangan lalu bentuk bulat baik dengan kedua tangan atau dengan satu tangan ditekan hingga adonan keluar melalui jari telunjuk dan jempol\n\n5.Masukkan adonan yang telah terbentuk ke dalam air panas\n\n6.Lanjutkan hingga semua adonan habis\n\n7.Jika pentol telah mengapung maka pentol telah matang. Angkat"},
            {"Tumis Kangkung",
                    "Bahan :\n\n1.1 ikat sayur kangkung segar (siangi, buang batang)\n2.1 buah tomat ceri (belah empat)\n3.4 siung bawang putih (memarkan)\n4.2 siung bawang merah (iris tipis)\n5.4 buah cabai rawit (iris serong tipis)\n6.Kaldu ayam bubuk (secukupnya)\n7.Garam (secukupnya)\n8.Gula (secukupnya)\n9.Margarin (secukupnya, pengganti minyak)\n10.Udang goreng (secukupnya, jika suka)",
                    "Cara Membuat :\n\n1.Panaskan margarin hingga leleh, tumis bawang putih, bawang merah dan cabai hingga harum serta matang\n\n2.Masukkan sayur kangkung, aduk rata\n\n3.Tambahkan garam, gula, kaldu ayam bubuk dan buah tomat serta udang goreng\n\n4.Aduk rata semua bahan, masak dengan api besar agar kangkung cepat matang dan tidak berubah warna\n\n5.Angkat tumis kangkung yang telah matang, sajikan selagi masih hangat"},
            {"Sapi Lada Hitam",
                    "Bahan :\n\n1.500 gr daging sapi bagian has, potong2\n2.1 sdm maizena utk campuran daging\n3.4 siung bawang putih dicincang\n4.1 bh bawang bombay, potong kasar\n5.paprika secukupnya potong2\n6.1.5 sdm kecap manis\n7.1 sdm kecap asin\n8.1 sdt minyak wijen\n9.1 sdt saus tiram\n10.1 sdt lada hitam\n11.secukupnya garam, gula dan air\n12.1 sdm maizena dilarutkan dg air utk mengentalkan",
                    "Cara Membuat :\n\n1.Daging sapi beri sedikit kecap asin lalu campur dg maizena aduk rata. Diamkan sebentar\n\n2.Tumis daging sebentar. Angkat. Sisihkan\n\n3.Tumis bawang bombay, bwg putih, paprika sampai harum\n\n4.Masukkan semua kecap, saus dkk beri air, garam, gula\n\n5.Masukkan daging. Masak sampai bumbu meresap. Kental kan kuah dg larutan maizena. Angkat. Sajikan"},
            {"Sate Padang",
                    "Bahan :\n\n1.250 gr fillet daging ayam\n2.1 bh jeruk nipis\n3.1 ruas jahe (geprek)\n4.1 ruas lengkuas (geprek)\n5.1 lbr sereh (ambil putihnya, geprek)\n6.1 lbr daun kunyit (sobek2)\n7.3 lbr daun jeruk\n8.3 butir kapulaga\n9.3 butir cengkeh\n10.1 butir bunga lawang\n11.3 sdm tepung beras (larutkan dgn 50ml air)\n12.Secukupnya garam, gula dan lada bubuk\n13.600 ml air",
                    "Bumbu Halus :\n\n1.8 siung bawang merah\n2.4 siung bawang putih\n3.3 cm kunyit\n4.1/2 sdt jintan\n5.1/2 sdt ketumbar\n6.4 bh cabe merah (sesuai selera)\n7.3 bh cabe rawit\n\n\nPelengkap :\n\nlontong dan bawang goreng\n\n\nCara Membuat :\n\n1.Cuci bersih ayam, potong2 dadu seperti potongan sate. Lalu lumuri dgn perasan jeruk nipis. Diamkan 10menit\n\n2.Tumis bumbu halus, tambahkan bunga lawang, kapulaga, sereh, jahe, lengkuas, daun kunyit, daun jeruk. Lalu masukkan ayam. Masak sebentar sampai bumbu meresap. Tambahkan air. Beri garam, gula dan lada. Masak sampai ayam sedikit lunak\n\n3.Keluarkan ayamnya. Sisihkan di piring. Tusuk dgn tusukan sate. Lalu panggang di pan/teflon sampai matang. Saring sisa kuah memasak ayam tadi. Lalu tambahkan air larutan tepung beras. Masak sampai mengental. Tes rasa\n\n4.Daging ayamnya empuk dan wangi rempah ya\n\n5.Sajikan dengan lontong dan taburan bawang goreng.. Hmm..harumnya masyaallah\n\n6.Selamat mencoba"},
            {"Mie Udang Pedas",
                    "Bahan :\n\n1.1 bungkus mie telor (siram air panas, tiriskan)\n2.1/4 udang ukuran sedang (kupas kulitnya)\n3.Minyak (secukupnya, untuk menumis)",
                    "Bumbu Halus :\n\n1.4 siung bawang merah\n2.2 siung bawang putih\n3.10 buah cabai rawit\n4.5 buah cabai keriting\n5.Garam (secukupnya)\n6.Lada bubuk (secukupnya)\n7.Penyedap masakan (secukupnya, jika suka)\n8.Gula (secukupnya)\n\n\nCara Membuat :\n\n1.Panaskan minyak, tumis bumbu halus hingga harum.\n\n2.Masukkan udang, masak hingga setengah matang atau berwarna merah\n\n3.Masukkan mie, tambahkan sedikit air agar mie matang sempurna dan bumbu meresap\n\n4.Masak selama beberapa menit, koreksi rasa, angkat jika sudah matang\n\n5.Sajikan mie udang ini selagi masih hangat"},
            {"Mie Goreng Bakso",
                    "Bahan :\n\n1.2 bungkus mie instan goreng\n2.10 buah bakso\n3.2 siung bawang putih\n4.2 sdm saus cabai\n5.2 sdm kecap manis\n6.1/2 sdt merica bubuk\n7.garam secukupnya\n8.minyak secukupnya",
                    "Cara Membuat :\n\n1.Rebus mie instan setengah matang, tiriskan, campur dengan minyak secukupnya agar tidak lengket dan padat\n\n2.Cincang bawang putih, tumis hingga harum. Masukkan bakso dan goreng dengan bumbu hingga agak matang\n\n3.Masukkan mie rebus dan semua bumbu mie instan. Aduk rata dengan cepat masak sebentar hingga agak kering atau tidak terlalu basah. Jadi deh"},
            {"Ikan Pindang Sambal Bawang",
                    "Bahan :\n\n",
                    "Cara Membuat :\n\n"},
            {"Sambal Matah",
                    "Bahan :\n\n",
                    "Cara Membuat :\n\n"}
};


    int[] gambar = {R.drawable.nasigoreng,
            R.drawable.mieayam,
            R.drawable.bakso,
            R.drawable.tumiskangkung,
            R.drawable.sapiladahitam,
            R.drawable.satepadang,
            R.drawable.mieudangpedas,
            R.drawable.miegorengbakso,
            R.drawable.ikanpindangsambalbawang,
            R.drawable.sambalmatah
    };

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //judul = getResources().getStringArray(R.array.mieay);

        AdapterResep adapterMakanan = new AdapterResep(this, data, gambar);

        recycleview.setHasFixedSize(true);
        recycleview.setLayoutManager(new GridLayoutManager(this, 2));
        recycleview.setAdapter(adapterMakanan);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            // Handle the camera action
        } else if (id == R.id.about) {
            startActivity(new Intent(MainActivity.this,AboutActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

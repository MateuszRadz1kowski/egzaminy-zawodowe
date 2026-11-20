using System.IO;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _2024_styczen_moje_dzwieki
{
    public partial class MainWindow : Window
    {
        public List<Album> albumy = [];
        private int currentAlbum = 0;

        public MainWindow()
        {
            InitializeComponent();
            string dataStr = File.ReadAllText(@"C:\Users\Uczen204\Desktop\2024-styczen-moje-dzwieki\2024-styczen-moje-dzwieki\Data.txt");
            var strArray = dataStr.Split(new[] { "\r\n" }, StringSplitOptions.RemoveEmptyEntries);

            for (var i = 0; i <= strArray.Length - 1; i += 5)
            {
                albumy.Add(new Album(
                    strArray[i],
                    strArray[i + 1],
                    int.Parse(strArray[i + 2]),
                    int.Parse(strArray[i + 3]),
                    int.Parse(strArray[i + 4]),
                    0
                ));
            }

            WyswietlAlbum(currentAlbum);
        }

        private void WyswietlAlbum(int index)
        {
            var album = albumy[index];
            Wykonawca.Text = album.wykonawca;
            Utwor.Text = album.utwor;
            iloscUtworow.Text = album.iloscUtworow.ToString();
            rokWydania.Text = album.rokWydania.ToString();
            id.Text = album.id.ToString();
            //if (album.iloscPobran != 0)
            //{
            //    iloscPobran.Text = album.iloscPobran.ToString();
            //}
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            albumy[currentAlbum].iloscPobran += 1;
        }

        private void left_Click(object sender, MouseButtonEventArgs e)
        {
            currentAlbum = (currentAlbum + 1) % albumy.Count;
            WyswietlAlbum(currentAlbum);
        }

        private void right_Click(object sender, MouseButtonEventArgs e)
        {
            currentAlbum = (currentAlbum - 1 + albumy.Count) % albumy.Count;
            WyswietlAlbum(currentAlbum);
        }
    }

    public class Album
    {
        public string wykonawca;
        public string utwor;
        public int iloscUtworow;
        public int rokWydania;
        public int id;
        public int iloscPobran;

        public Album(string wykonawca, string utwor, int iloscUtworow, int rokWydania, int id, int iloscPobran)
        {
            this.wykonawca = wykonawca;
            this.utwor = utwor;
            this.iloscUtworow = iloscUtworow;
            this.rokWydania = rokWydania;
            this.id = id;
            this.iloscPobran = iloscPobran;
        }
    }
}
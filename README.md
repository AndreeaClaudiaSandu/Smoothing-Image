# Smoothing-Image
Operația de Image Smoothing înseamnă că fiecare pixel din imaginea sursă este răspândit și amestecat în pixeli înconjurători. Un alt mod de a privi acest lucru este că fiecare pixel din imaginea de destinație este format dintr-un amestec de pixeli din jurul său din imaginea sursă. Operația de care avem nevoie pentru acest lucru se numește convoluție. Modul în care funcționează este: ne imaginăm că trecem o matrice de numere peste imaginea noastră. 
Această matrice se numește convolution kernel. Pentru fiecare pixel din imagine, luăm numerele corespunzătoare din kernel și pixelii peste care se află, îi înmulțim și adăugăm toate rezultatele împreună pentru a face noul pixel.   

In clasa Main sunt pornite thread-urile.
Clasa Buffer se ocupa de sincronizarea celor doua fire de executie. Aceasta resursa comuna,  Buffer  trebuie sa permita sau nu accesul la continutul sau. In felul acesta efortul sincronizarii este transferat de la producer/consumer la un nivel mai jos, cel al resursei critice. 
In clasa Producer prin metoda run se citeste cate un sfert din fisier(poza) si se astepta sa 
fie preluat continutul de clasa Consumer. 
In clasa Consumer prin metoda run se preia informatia din buffer si se pune in vectorul de bytes “rezultat”. In urma preluarii informatiei pentru cele 4 sferturi se converteste vectorul de bytes inintr-o imagine BufferedImage. 
Se citesc de la tastatura valorile pentru raze si pentru numarul de iteratii si se creeaza un obiect de tip Smoothing cu parametri setați anterior de utilizator. Se aplică metoda filter din cadrul clasei Smoothing obiectului de tip BufferedImage pentru modificarea imaginii. In final se realizeaza scrierea în fișierul destinație. Tot in Consumer se calculeaza si timpii pentru citire, procesare si scriere. 
Clasa Smoothing se ocupa de procesarea imaginii prin aplicarea metodei blur in interiorul metodei filter. Smoothing este o subclasă a clasei abstracte AbstractClass și are ca atribute raza pentru convoluția pe orizontală, raza pentru convoluția pe verticală și numărul de iterații al metodei de estompare. Metoda filter are ca parametri obiectele de tip BufferedImage sursă și destinație. În metoda filter se obțin valorile RGB ale pixelilor din imagine, după care se aplică metoda blur pe orizontală și pe verticală de un număr de ori egal cu numărul de iterații specificat ca parametru și se setează din nou valorile RGB obținute ale pixelilor. 
Interfata Interface se foloseste pentru afisarea parametrilor acesteia. Cuprinde trei metode, afisarea razei pentru convolutia pe orizontală, afișarea razei pentru convoluția pe verticală și afișarea numărului de iterații. 
Clasa SubClass este o subclasa a clasei Smoothing si are ca parametru Boxnumber de tip int. Contine metod mostenite din clasa parinte si metode de obtinere si setare a noului parametru. 
Clasa AbstractClass este o clasa abstracta, parintele clasei Smoothing. Clasa copil utilizeaza metodele de obtinere si setare a valorilor RGB a pixelilor dintr-o imagine. 
Clasa CompClass curpinde doua functii utilizate in Smoothing, una de tip int si una float pentru a limita un numar intre o valoare de minim si una de maxim. 
 
 
 

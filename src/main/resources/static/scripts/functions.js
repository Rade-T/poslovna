function highlightRow(row) {
	// ne reagujemo na klik na header tabele, samo obicne redove
	// this sadrzi red na koji se kliknulo
	if (!$(row).hasClass("header")) {
		// klasa highlighted postavlja pozadinu na plavu
		// njenim dodavanjem ili uklanjanjem oznacavamo da neki red
		// dobija, odnosno gubi selekciju
		// uklanjamo sa trenutno selektovanog
		$(".highlighted").removeClass("highlighted");
		// dodajemo na novi selektovani
		$(row).addClass("highlighted");
		// pozivamo sinhronizaciju, prosledjujemo dati red
		sync($(row));
	}
}

function goFirst() {
	// indeksi pocinju od 1
	// prvi red je header, zato se trazi drugo dete
	item = $("table tr:nth-child(2)");
	$(".highlighted").removeClass("highlighted");
	item.addClass("highlighted");
	sync(item);
}

function goLast() {
	// indeksi pocinju od 1
	// prvi red je header, zato se trazi drugo dete
	item = $("table tr:last-child");
	$(".highlighted").removeClass("highlighted");
	item.toggleClass("highlighted");
	sync(item);
}

function goNext() {
	highlighted = $(".highlighted");
	// nalazi poziciju trazanog u okviru selektovane selekcije
	// indeksi pocinju od 0
	var count = $("tr").length;
	if (count == 0)
		return;
	index = $("tr").index(highlighted);
	if (index < 0)
		return;
	// ako smo na poslednjem, predji na prvi (odnosno drugi red, preskacuci
	// header)
	selectChild = 2;
	// inace
	if (index < count - 1)
		selectChild = index + 2; // povecavamo za 1, i jos dodajemo 1 jer nth
	// child pocinje od 1, indeksi od 0
	item = $("tr:nth-child(" + selectChild + ")");
	$(".highlighted").removeClass("highlighted");
	item.addClass("highlighted");
	sync(item);
}

function goPrevious() {
	highlighted = $(".highlighted");
	index = $("tr").index(highlighted);
	var count = $("tr").length - 1;
	if (count == 0 || index < 0)
		return;
	if (index == 1)
		index = count + 1;
	else
		index;
	item = $("tr:nth-child(" + index + ")");
	$(".highlighted").removeClass("highlighted");
	item.addClass("highlighted");
	sync(item);
}

function sync(item) {
	oznaka = item.find(".code").html()
	naziv = item.find(".name").html()
	id = item.find(".idCell").html()
	$("#oznaka").val(oznaka);
	$("#naziv").val(naziv);
	$("#id").val(id);
}
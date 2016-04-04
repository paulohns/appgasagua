function somenteNumero02(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}

function formataMonetario(v) {
	v = v.replace(/\D/g, "");
	v = v.replace(/(\d{1})(\d{15})$/, "$1.$2");
	v = v.replace(/(\d{1})(\d{11})$/, "$1.$2");
	v = v.replace(/(\d{1})(\d{8})$/, "$1.$2");
	v = v.replace(/(\d{1})(\d{5})$/, "$1.$2");
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2");
	return v;
}

function soAlfaNumerico(s) {
	return s.replace(/[^a-zA-Z0-9]+/g, "");
}

function somenteNumero(classe) {
	$(classe)
			.keyup(
					function(e) {

						if (!((e.keyCode == 46) || (e.keyCode == 8) // DEL e
																	// Backspace
								|| ((e.keyCode >= 35) && (e.keyCode <= 40)) // HOME,
																			// END,
																			// Setas
								|| ((e.keyCode >= 96) && (e.keyCode <= 105)) // Númerod
																				// Pad
								|| ((e.keyCode >= 48) && (e.keyCode <= 57)) || ((e.keyCode == 9) || (e.shiftKey && e.keyCode == 9)))) {
							e.preventDefault();
						}// Números
						else if (e.shiftKey) {
							e.preventDefault();
						}
					});
}

function formatNumeroPrice(elemento) {
	$(elemento).keyup(
			function(event) {

				// define como 0,00 para não haver
				// problemas na converção
				if ($(this).val() == "") {
					$(this).val("0,00");
					return;
				}
				var num = $(this).val();
				// Remove os pontos
				num = num.replace(/[\.-]/g, "");
				// remove as virgulas
				num = num.replace(/[\,-]/g, "");

				num = parseInt(num, 10);

				if (num % 1000 == num) {
					if (num % 10 == num)
						$(this).val("00,0" + num);
					else if (num % 100 == num)
						$(this).val("0," + num);
					else {
						format = num.toString().substring(0, 1);
						decimais = num.toString().substring(1,
								num.toString().lenht);
						$(this).val(format + "," + decimais);
					}
				} else {
					format = num.toString();
					decimais = format.substring(format.length - 2,
							format.length);
					convertido = convertMil(format.substring(0,
							format.length - 2));
					$(this).val(convertido + "," + decimais);
				}

				function convertMil(numero) {
					numero = numero.toString();
					numeroFormat = "";

					qtdPontos = parseInt(numero.length / 3);
					tamnhoString = parseInt(numero.length);
					if (numero.length < 4) {
						return numero;
					}
					for (i = 0; i < qtdPontos + 1; i++) {
						stringInit = (tamnhoString - 3) < 0 ? 0
								: (tamnhoString - 3);
						if (i == 0)
							numeroFormat = numero.substring(stringInit,
									(tamnhoString));
						else
							numeroFormat = numero.substring(stringInit,
									(tamnhoString))
									+ "." + numeroFormat;

						tamnhoString = (tamnhoString - 3);

						if (tamnhoString == 0)
							break;
					}
					return numeroFormat;
				}
			});
}



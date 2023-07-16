<?php
$code = file_get_contents("https://www.imdb.com/chart/top");
$code = str_replace(">", "<>", $code);

echo $code
?>
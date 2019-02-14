use strict;
use warnings;
$|=1;


sub main(){
	unless(open (FH, ">>D:\\cdr_20180903140000.txt")){
		die "Unable to open file";
	}
	while (my $line = <FH>){
		print "Start";
	if ($line=~/\n/){
		print "$line";
	}
 }
}
main();
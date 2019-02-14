use LWP::Simple;
use warnings;
our $color = 'RED';
print "Hello to the world!\n$color";
$z = myfun();
print "$z";

#$ver="2018-07-11 15:50:";
{
	my $color = 'BLUE';
	print "\n$color";
}

#print"$ver\n";
#$ver1=($ver++);
#print"$ver\n";
$a = 10;
$b = 20;
print "\nSum is $a+$b";
print "\nSum is" . ( $a + $b );
print "\nP" x 10;

sub myfun() {
	print "My Function";
	$num1 = 100;
	$num2 = 200;
	$sum  = $num1 + $num2 + 10;
	return $num1;
}
$count = open( FH, ">>myFile.txt" ) or die "Unable to open the myFile.txt, $!";
print FH "\nLINE 1";
print FH "\nLINE 2";
print FH "\nLINE 3";
print FH "\n$count";
close(FH);
$string = "Hello Perl";
$string =~ tr/l/z/;
print "$string";
open( FH, "D:\\My Workspace\\Prism Docs\\TLOG_REF.LOG" )
  or die "Unable to open the myFile.txt, $!";

while (<FH>) {
	if ( $_ =~ m/CHG=1/g ) {
		print( "\nARRAY MATCHES: " . $_ );
	}
	else {
		print("\nNOT MATCHES");
	}
}

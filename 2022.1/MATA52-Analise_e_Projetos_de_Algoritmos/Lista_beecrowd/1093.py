import math


def calc_probabilidade(vital1, vital2, ataque, dano):
    jogada1 = math.ceil(vital1 / dano);
    jogada2 = math.ceil(vital2 / dano) + jogada1;
    jogada3 = (6 - ataque)/ataque;
    if (ataque == 3):
        return jogada1 / jogada2;
    return (1 - jogada3**jogada1) / (1 - jogada3**jogada2);


vital, evital2, atq, damage = [int(x) for x in input().split()];
while (vital != 0 and evital2 != 0 and atq != 0 and damage != 0):
    calc = calc_probabilidade(vital, evital2, atq, damage) * 100;
    print('%.1f' % calc);
    vital, evital2, atq, damage = [int(x) for x in input().split()];
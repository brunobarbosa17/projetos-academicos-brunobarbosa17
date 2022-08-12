# -*- coding: utf-8 -*-
"""MATA52-Semana01-Paládio.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/15Q6F-IrYk2JRtzqJ4RqaOXCwRY8Yu_IB

# MATA52 - Exercícios da Semana 01

*   Grupo: Paládio
*   Autores: 
 * [Bruno de Lucas Barbosa](https://www.youtube.com/watch?v=pgXozIma-Oc&list=OLAK5uy_mieL-przDrJDrJdzLrlXeUralT8JvoWEY) (Responsável)
     * Convidei os membros para uma primeira tentativa de realizar a lista na quarta-feira(09/03) e todos compareceram.
Conseguimos pensar bastante com ajuda de todos e resolvemos 3 das 4 questões com uma certa dificuldade e marcamos outro encontro no dia 11/03 onde todos compareceram para tentarmos realizar a questão que faltou
 * [Elis Marcela de Souza Alcantara](https://www.youtube.com/watch?v=x-xTttimcNk&list=OLAK5uy_mieL-przDrJDrJdzLrlXeUralT8JvoWEY)
     * Ajudou ativamente em TODAS as questões buscando formas de resolver e conteúdos para que todos os membros pudessem acompanhar e contribuir com a atividade e compareceu em todos os 2 encontros.
 * [Lucas dos Santos Lima](https://www.youtube.com/watch?v=hjpF8ukSrvk&list=OLAK5uy_mieL-przDrJDrJdzLrlXeUralT8JvoWEY)
     * Ajudou ativamente em TODAS as questões, trazendo um conhecimento matemático exemplar junto de Elis e sintático para que pudessemos realizar a atividade.
  * [Monique Silva](https://www.youtube.com/watch?v=hjpF8ukSrvk&list=OLAK5uy_mieL-przDrJDrJdzLrlXeUralT8JvoWEY)
     * Esteve presente em todos o 2 encontros, além de ajudar ativamente em TODAS as questões buscando formas de resolver e buscando conteúdos relevantes para todos os membros acompanharem.

# Instruções (não apagar)
1.   Após criar este notebook, altere o nome do notebook/documentação incluindo o nome do seu grupo. Por exemplo, se você é do grupo Ouro, altere o nome do notebook para "MATA53-Semana01-Ouro.ipynb"
1. Compartilhe este documento com todos os membros do grupo (para participarem da elaboração deste documento). É importante que o notebook utilizado seja o mesmo compartilhado para que os registros de participação e colaboração fiquem salvos no histórico.
1.   Incluia o nome completo dos autores na lista de autores que auxiliaram na elaboração deste notebook. Destaque o responsável como sendo o(a) primeiro(a) autor(a). Relatar brevemente a contribuição de cada membro do grupo.
1. Utilize os recursos de blocos de texto e de código para adicionar as suas respostas, sem alterar os blocos de texto e código existente. Não economize, esses blocos são de graça.
1. Ao concluir a atividade, compartilhe o notebook com januario.ufba@gmail.com (dando permisão para edição) e deixando o aviso de notificação marcado, para que eu receba o seu e-mail. Identificar o nome do grupo na mensagem de compartilhamento.

# Exercícios

# **1. Ordene as seguintes funções por ordem de crescimento:**
  * f(n) = $n^2$
  * f(n) = $n \log n$
  * f(n) = $n$
  * f(n) = $\log n$
  * f(n) = $\sqrt{n}$

  Utilize o código abaixo para facilitar a sua análise
"""

# Commented out IPython magic to ensure Python compatibility.
# %matplotlib inline
import matplotlib.pyplot as plt
plt.style.use('seaborn-whitegrid')
import numpy as np

n = np.linspace(0.1, 10, 1000)
# plt.plot(n, 2*n, linestyle='solid')
# plt.plot(n, n*np.log(np.power(n,2)), linestyle='dashed')

plt.plot(n, np.power(n, 2), linestyle='solid', color = '#ff0000') # red
plt.plot(n, n*np.log(n), linestyle='solid', color = '#6600ff') # purple
plt.plot(n, n, linestyle='solid', color = '#0000ff') # blue
plt.plot(n, np.log(n), linestyle='solid', color = '#00ff00') # green
plt.plot(n, np.sqrt(n), linestyle='solid', color = '#ff66ff') # pink

"""#### 1. Resposta:

De acordo com a análise feita com base no trecho de código:
```python
plt.plot(n, np.power(n, 2), linestyle='solid', color = '#ff0000') # red
plt.plot(n, n*np.log(n), linestyle='solid', color = '#6600ff') # purple
plt.plot(n, n, linestyle='solid', color = '#0000ff') # blue
plt.plot(n, np.log(n), linestyle='solid', color = '#00ff00') # green
plt.plot(n, np.sqrt(n), linestyle='solid', color = '#ff66ff') # pink
```

Podemos obter o gráfico que auxiliou a identificação de uma superioridade muito grande da função * f(n) = $n \log n$ em comparação com a * f(n) = $n^2$

![image.png](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAXEAAAD1CAYAAACm0cXeAAAgAElEQVR4nO3deXxTVd7H8U+S7htdaICyVERFBIqAzAgCygPihoIrtbI4Oi6jgzqDgz6Mioob6DiCOuCI4ghPtU5ZZNSxHXyJohaQgghOlEXWAl2kpVvSZnv+OG3TQlvaNOnN8nv3dV9Jk5vkdyn9cjj3nnN0TqfTiRBCCL+k17oAIYQQ7pMQF0IIPyYhLoQQfkxCXAgh/JiEuBBC+DEJcSGE8GMhnf2B+fn5nf2RQgjh94YPH97s450e4tByMc0xmUwMGDDAi9X4nmA8ZgjO4w7GY4bgPO6OHHNrjV/pThFCCD8mIS6EEH5MQlwIIfyYhLgQQvixNoX47t27mTBhAitXrgTg2LFjTJ8+nYyMDB588EFqa2sBWLduHTfeeCM333wz//znP71XtRBCCKANIV5dXc38+fMZOXJkw2OLFy8mIyODzMxMUlNTyc7Oprq6mtdff5133nmHFStW8I9//IOysjKvFi+EEMHujCEeFhbGm2++idFobHhs8+bNjB8/HoBx48aRl5fHjh07GDx4MLGxsURERDBs2DC2bdvmvcqFEEKc+TrxkJAQQkKa7mY2mwkLCwMgKSmJ4uJiSkpKSExMbNgnMTGR4uJiD5crhBB+xumEP/6RXjt3wvr1Hn/7Dg/2aWlNidbWmjCZTG1+f4vF0q79A0EwHjME53EH4zFDcB13wnvv0f2VV6i8+26OeOGY3QrxqKgoLBYLERERFBYWYjQaMRqNlJSUNOxTVFTEhRde2Ozr2zNqSUZ2BY9gPO5gPGYIouP+8kt4/nmYNImyBx7wnRGbo0aNIicnB4Dc3FzGjBnDkCFD2LlzJ+Xl5VRVVbFt2zYuuugitwoWQgi/d+gQ3HQT9OsHK1eC3jtXdJ+xJb5r1y4WLFhAQUEBISEh5OTk8NJLL/Hoo4+SlZVFSkoKU6ZMITQ0lNmzZ3PnnXei0+m4//77iY2N9UrRQgjh08xmuP56qKmBDz+ELl3g6FGvfNQZQ3zQoEGsWLHitMeXL19+2mNXXnklV155pWcqE0IIf+R0wt13w/btsG4d9O/v1Y/TZBZDIYQIWK+8orpP5s+HSZO8/nEy7F4IITxl/Xp4+GG44QaYO7dTPlJCXAghPGH/fpg6FQYMgHfe8dqJzFNJiAshREdVVsKUKeBwwNq10IkXdUifuBBCdITDAdOnw65d8O9/wznndOrHS4gLIURHPPGEan0vWgQTJ3b6x0t3ihBCuCszE559Fu66C2bN0qQECXEhhHDHli1wxx0wdiy89hrodJqUISEuhBDtVVCgTmT26AHZ2VA3q6sWpE9cCCHao7paBXhFBeTkQHKypuVIiAshRFs5naoLJT9fncwcPFjriiTEhRCizZ59FrKy4IUX4LrrtK4GkD5xIYRom9Wr4fHHYdo0mDNH62oaSIgLIcSZfPedGtDz61/Dm29qdiVKcyTEhRCiNcePq66TxETVDx4RoXVFTUifuBBCtKS6WgX4L7/Axo3QvbvWFZ1GQlwIIZrjcMCMGbB1K6xZA8OGaV1RsyTEhRCiOXPnwqpV8PLLMHmy1tW0SPrEhRDiVMuWwYIFcO+98NBDWlfTKglxIYRo7LPP4He/UzMSvvqqT12J0hwJcSGEqGcywY03qsWNP/gAQny/x1lCXAghAIqL4ZprIDwcPv4YunTRuqI28f1/ZoQQwtssFjWp1bFjsGEDpKZqXVGbSYgLIYKb0wm/+Q188w38859qVKYfke4UIURwmzcP3n8fnn8ebrpJ62raTUJcCBG83nkH5s9X08s+8ojW1bhFQlwIEZxyctTamBMmwJIlPn8pYUskxIUQwWf7dtV1csEFalSmhsurdZSEuBAiuBw8CFdfDQkJ8MknEBendUUdIlenCCGCR2kpXHUVmM2wfj307Kl1RR3mVohXVVXxyCOPcPLkSaxWK/fffz/Jyck8+eSTAPTv35+nnnrKo4UKIUSH1F8Lvm+f6g8fOFDrijzCrRBfs2YNffv2Zfbs2RQWFjJz5kySk5OZO3cuaWlpzJ49my+++IJLL73U0/UKIUT7ORwwcyZ8+SW89x5cdpnWFXmMW33iCQkJlJWVAVBeXk58fDwFBQWkpaUBMG7cOPLy8jxXpRBCdMScOWoulIULIT1d62o8yq2W+DXXXMPq1au5/PLLKS8vZ8mSJTz99NMNzyclJVFcXNzi600mU5s/y2KxtGv/QBCMxwzBedzBeMzQucedsGIF3f/yF05kZFB4zTVqkisNeOuY3QrxDz/8kJSUFN566y1+/PFH7r//fmJjYxuedzqdrb5+wIABbf4sk8nUrv0DQTAeMwTncQfjMUMnHveqVfDCCzBlConvvkuiweD9z2xBR445Pz+/xefcCvFt27YxevRoAM4//3xqamqw2WwNzxcWFmI0Gt15ayGE8IyvvoLbboOLL4bMTNAwwL3JrT7x1NRUduzYAUBBQQHR0dH069ePrVu3ApCbm8uYMWM8V6UQQrTHzp0waZKajXDdOoiM1Loir3GrJT516lTmzp3LtGnTsNlsPPnkkyQnJ/PEE0/gcDgYMmQIo0aN8nStQghxZgcOwBVXQHQ05OZC165aV+RVboV4dHQ0ixYtOu3xzMzMDhckhBBuKypSy6qZzbBxo1/NC+4uGbEphAgMFRVqOP3hw2o05qBBWlfUKSTEhRD+r6YGrr8evvsO1q6FSy7RuqJOIyEuhPBvdjvMmKFWqX/nHXVCM4jILIZCCP/ldMKDD7pGY86cqXVFnU5CXAjhv555Bl5/HR5+GP70J62r0YSEuBDCPy1dCk88obpSFizQuhrNSIgLIfxPVhbcdx9ccw0sWwb64I2y4D1yIYR/+vhjmDZNXYHywQcQGqp1RZqSEBdC+I8vvlBrY6alwUcfQVSU1hVpTkJcCOEftmxRlw/27atW5unSReuKfIKEuBDC9+3aBVdeCcnJ8J//BPx8KO0hIS6E8G1798Lll6uZCANkcWNPkhGbQgjfdeQITJgAVqtaH/Pss7WuyOdIiAshfFNRkQrwEyfg88/hggu0rsgnSYgLIXxPWZmaE/zQIXUSc/hwrSvyWRLiQgjfUlmpBvH88INalUdWCWuVhLgQwndUV6vLCDdvhvffV1ekiFZJiAshfIPZDJMnqxV5VqxQg3rEGUmICyG0V1MDN9yg5gRfvhwyMrSuyG9IiAshtFVbCzffDJ9+Cn//e1DOCd4RMthHCKEdqxVuvRX+9S81L/hdd2ldkd+REBdCaMNmU3OBr14Nf/2rmlpWtJuEuBCi89ntcMcd6gqUhQvhoYe0rshvSZ+4EKJzORz0mDdPtcCfeSZol1XzFGmJCyE6j8MB991H/OrVamm1P/9Z64r8noS4EKJzOBxw773wxhuU/Pa38OSTWlcUEKQ7RQjhfQ4H3H03vPUW/PnPFGdk0FWn07qqgCAtcSGEd9ntcOedKsCfeALmzwcJcI+RlrgQwnvqr0J5913VfTJvntYVBRy3Q3zdunUsW7aMkJAQHnjgAfr378+cOXOw2+0kJyfz4osvEhYW5slahRD+xG6H22+HlStV6/uxx7SuKCC51Z1SWlrK66+/TmZmJkuXLuWzzz5j8eLFZGRkkJmZSWpqKtnZ2Z6uVQjhL2w2mD5dBfhzz0mAe5FbIZ6Xl8fIkSOJiYnBaDQyf/58Nm/ezPjx4wEYN24ceXl5Hi1UCOEnbDaYNg3eew8WLID//V+tKwpobnWnHDlyBIvFwr333kt5eTmzZs3CbDY3dJ8kJSVRXFzs0UKFEH7AalUzEGZnw0svwezZWlcU8NzuEy8rK+O1117j6NGjzJgxA6fT2fBc4/vNMZlMbf4ci8XSrv0DQTAeMwTncQfSMetqa0l5+GHi1q+n8JFHOHH11dDCsQXScbeVt47ZrRBPSkpi6NChhISE0KdPH6KjozEYDFgsFiIiIigsLMRoNLb4+gEDBrT5s0wmU7v2DwTBeMwQnMcdMMdcXa3mA1+/HhYvptusWXRrZfeAOe526Mgx5+fnt/icW33io0ePZtOmTTgcDkpLS6murmbUqFHk5OQAkJubyxhZF0+I4FBRAVddBbm56lrwWbO0riiouNUS79atG1dccQW33HILAI899hiDBw/mkUceISsri5SUFKZMmeLRQoUQPujECRXg27ZBZiakp2tdUdBxu088PT2d9FN+YMuXL+9wQUIIP1FYCBMnwo8/wqpVcN11WlcUlGTEphCi/Y4cgQkT4PBh+PhjdV9oQkJcCNE+P/8M48errpScHBg9WuuKgpqEuBCi7Uwm1eq2WNTK9BddpHVFQU9mMRRCtM22bXDppWpOlC++kAD3ERLiQogz+/xzuOwyiIyEL7+EQYO0rkjUkRAXQrRuzRq48kro3Ru++QbOO0/rikQjEuJCiJYtWwY33QTDhsHGjdCzp9YViVNIiAshTud0qhkI77oLLr9cDadPTNS6KtEMCXEhRFMOB/zpT/Doo3DrrbBuHURHa12VaIFcYiiEcLFaVev7H/+A3/8eFi0CvbT1fJmEuBBCMZvhllvgo4/gqafg8cdlQWM/ICEuhFCjL6+7Tl198re/we9+p3VFoo0kxIUIdvv3q5kI9++H999XrXHhNyTEhQhm27bB1VdDTQ385z8wdqzWFYl2kjMWQgSrTz9VoR0eDl9/LQHupyTEhQhGb78NkybBuedCXh5ccIHWFQk3SYgLEUycTnXlyZ13qulkv/wSUlK0rkp0gPSJCxEsrFZ11clbb8Htt8Pf/w6hoVpXJTpIWuJCBIPKSpg8WQX4E0+o7hQJ8IAgLXEhAt3hw3DttbBrl2p933WX1hUJD5IQFyKQffutGsRTXa3WwrziCq0rEh4m3SlCBKpVq9RKPBERaiSmBHhAkhAXItA4nfD882oe8AsvhM2bYeBArasSXiLdKUIEktpauOceeOcdSE+H5ctVS1wELGmJCxEofvkFJk5UAf7EE5CZKQEeBKQlLkQg2L1bjcA8eBBWroTbbtO6ItFJJMSF8He5uTB1KoSEwGefwejRWlckOpF0pwjhr5xOePllNY1s797qBKYEeNCREBfCH1ksMHMmzJ6tRmJ+8w2cfbbWVQkNSIgL4W8KCtS0sStWqMmssrMhJkbrqoRGOtQnbrFYmDRpEvfddx8jR45kzpw52O12kpOTefHFFwkLC/NUnUIIgE2b4PrroaICVq9W90VQ61BLfMmSJXTp0gWAxYsXk5GRQWZmJqmpqWRnZ3ukQCFEneXL1QjMyEg1B7gEuKADIb5v3z727t3LZZddBsDmzZsZP348AOPGjSMvL88zFQoR7KxWeOghuOMOdeLy229h8GCtqxI+wu0QX7BgAY8++mjD92azuaH7JCkpieLi4o5XJ0SwO35cLd6waBE88ADk5EBSktZVCR/iVp/42rVrufDCC+ndu3ezzzudzlZfbzKZ2vxZFoulXfsHgmA8ZgjO427tmCPz8+n5xz9iqKjg2AsvUH7ddbBnTydX6B3ys/Yct0J8w4YNHD58mA0bNnD8+HHCwsKIiorCYrEQERFBYWEhRqOxxdcPGDCgzZ9lMpnatX8gCMZjhuA87maP2emExYvh4YchNRXWr6dnWho9tSnRK+Rn3T75+fktPudWiL/yyisN91999VV69uzJ9u3bycnJYfLkyeTm5jJmzBh33lqI4FZZqRZteP99tZDDu+9CfLzWVQkf5rHrxGfNmsXatWvJyMigrKyMKVOmeOqthQgOu3fDxRdDVhY8+yysXSsBLs6ow3OnzJo1q+H+8uXLO/p2QgSntWvVCMzQUPj0UzUboRBtICM2hdCS1ar6vq+/Hs47D/LzJcBFu8gshkJo5eBBzpo+Hb7/Hn73OzWZlcz/LdpJQlwILXz4Idx+O2E2G3zwAdx8s9YVCT8l3SlCdKbaWjX6csoU6NeP/dnZEuCiQyTEhegs+/erYfOLFsGsWfD111j79NG6KuHnpDtFiM6werWa+wRg1Sq44QZt6xEBQ1riQniT2Qz33w833qiuPtm+XQJceJSEuBDesmMHDB8Of/ubWoHnq6+gb1+tqxIBRkJcCE9zOOCvf4Vf/QrKytRCxi+9BLJIivAC6RMXwpOOHYPbb1fBPXkyLFsGXbtqXZUIYNISF8JT1q1TizVs3AhLl8KaNRLgwuskxIXoqOpqNeJy8mTo3VsNnb/nHtDptK5MBAEJcSE6YvNmGDZMtbwfflgtZBxk82QLbUmIC+GOmhqYOxdGjVIt8fXr4cUXITxc68pEkJETm0K0144dMGOGmrjqN79RV6J06aJ1VSJISUtciLay2dRiDSNGQFER/Otf8PbbEuBCU9ISF6ItTCa1aMO330J6Orz2mqw6L3yCtMSFaI3dDn/5CwwdCj//rJZOe+89CXDhM6QlLkRLdu2CO++ELVvUosV//zt07651VUI0IS1xIU5VUwPz5qlLB3/+GTIz1SIOEuDCB0lLXIjGNm1Sre///hduuw1eeUVGXQqfJi1xIQAqK9WKO6NGQUUFfPwxrFwpAS58nrTEhcjNVcPkDxxQc38//zzExmpdlRBtIi1xEbyOHlWXC15xhZom9ssv1aWDEuDCj0iIi+Bjt8PixXD++bB2LTz5pBqFOWaM1pUJ0W7SnSKCy7ffwr33wrZtMHGianmfe67WVQnhNmmJi+BQVqb6u3/9a7VwQ1YWfPqpBLjwOocDjv8IlUXeaTNLS1wENqcT/u//1DSxxcUwaxbMnw9xcVpXJgKQ0wkl++Hg1kZbPljKocfQnozY5vnPlBAXgWvrVnjgAcjLU+tdfvKJGsAjhAc4nVB65JTA3gpVJ9TzIWHQawj8+jZIHQFhZxcAnv+fn4S4CDyFhWqu7+XLwWhUMw3OnAl66T0U7jt53BXUB75VtxVF6jl9CPQcDENvhNSL4KyLIGWQCvJ6JpPNK3W5HeILFy4kPz8fm83GPffcw+DBg5kzZw52u53k5GRefPFFwmR1b9GZamvh1Vfh6afBbIbZs+Hxx6XrRLRbZQkcOKWFXVagntPpoccFMOhqV2D3TIOwSG1qdSvEN23axJ49e8jKyqK0tJTrr7+ekSNHkpGRwVVXXcXLL79MdnY2GRkZnq5XiOb9+9/whz/ATz/B1VerhRrOO0/rqoQfqC5T/daNA/uXA67nu/WH8y5zBXavCyEiRrt6T+VWiI8YMYK0tDQA4uLiMJvNbN68maeeegqAcePG8fbbb0uIC+/btQvmzFEhft55arj81VdrXZXwUZYKOLS9LqzrukSK9rqe73o2nPUruPQ+Fdh9hkGkj6/54VaIGwwGoqKiAMjOzmbs2LF89dVXDd0nSUlJFBcXt/h6k8nU5s+yWCzt2j8QBOMxQ/uOO6SwkOTXXqPLmjU4YmIo+dOfOHHbbWrkpR/92cnP2nus1TqKf4qgcFcERT9EULgrkhP7w8CpAyC2uxXjIDPnTLLQbZCFbheYiYh3NLzeARw4Chz1TD3eOuYOndhcv3492dnZvP3220ycOLHhcafT2errBrRjNXCTydSu/QNBMB4ztPG4Kypg4UK1UIPNBg8+iOHPf6ZbUhLdOqdMj5KftWeYy+Hwdji0rW7Lh+M/gbMuk+O6w1kj4JKZqlskdTjEdQsFQoHOOWfSkWPOz89v8Tm3Q3zjxo0sXbqUZcuWERsbS1RUFBaLhYiICAoLCzEaje6+tRCns1ph2TI1RL6oSM158txz0Lev1pWJTlZ1QnWJ1If1oW1QtMf1fHwK9BkOw29R3SF9hkF8T9DptKvZm9wK8YqKChYuXMg777xDfHw8AKNGjSInJ4fJkyeTm5vLGJmHQniC0wlr1qhLBn/6CcaOVQsU/+pXWlcmOkFFsQrpg/lwuK6VXbLf9XxSKvQeBhfPUK3r3kOhS5Ct3eFWiH/yySeUlpby0EMPNTz2wgsv8Nhjj5GVlUVKSgpTpkzxWJEiCDmd6mTl44+reU7OP1+trnPttYHbpApyJ4+psG7cJVJ6xPV8cj/VFTLmnroW9lCIkene3QvxqVOnMnXq1NMeX758eYcLEoLPP4fHHoNvvlHdJf/4B2RkQIiMTQsETieUHw3hu59crexD26D8uHpepwPjeXDuWFd3SO+hEBWvbd2+Sn4rhM+I/O47NbfJZ59Bz56wdCnccQeEhmpdmnCTwwElP9eddNzu6sOuLFHDz+sHzlwwUYV16nA1VD1CpnRvMwlxob38fJg3j7M+/lgNk3/lFbXSTkSE1pWJdrDWwLEfVFgf/g6OfAdHdqhrs6FuaPogGHIdhPU8zq+u7k6vNAiL0rZufychLrTzzTfwzDOq7zshgaI//AHj009DjA8NhxPNqipVIX24ftsOx0zgqJseJDxGtagvngm9L1RbykAIrft32WQq5ewBQXYG0kskxEXncjpVn/czz6jbrl3Vmpb33ccvBQUYJcB9itMJJw41Desj38EvB137dOmhQjrt2rrAHqpGPsp8Y51DQlx0DqdTLcLwzDOqBd6jB7z8Mtx9N0RHq30KCrStMcjZrWrxgsaBffg7qC5Vz9efcDx7JIz9nauFHeePo6wCiIS48C6bDVatUqMst22DPn3g9dfVCUvp89aMpVL1VzcO66O7wFajng+NUFOrDr9ZBXWvC6FXGoRHa1u3OJ2EuPCOyko1j/df/woHDqhl0N56C6ZNU/ObiE7hcMAv++HI93XbDij4Hor3ufaJTlRdIONmubpDup0HBkkHvyA/JuFZx46pOb2XLFHrWo4era42ufZa6ST1MnM5FOxUIX1khwrtgp1QU6me1+nAeK4K6ZEzVeu6z9DAHpIeDCTEhWf88IPq4165UnWh3HCDWpTh4ou1rizgOByqJd0krL9vOhw9Kl4tVDDydug9RN1PGSjdIYFIQly4z2aDdevgtdfUlSaRkXDXXWpxhn79tK4uIFSXqdZ0466Qgp1QW62e1+lV18dZv4JLfqv6rXulQUJvaV0HCwlx0X5FRWpGwSVL4MgRSE2FBQvgzjshKUnr6vyS3QbFe1VAH64P6++bXsoXnaiuvR59V11YD1GjHbVaFkz4Bglx0Xbffqta3e+/r9aznDBBfT9pEhgMWlfnF+qvuz66Cwp2genrFLIPwXET2GrVPnoDdD8fzh4FY+9VYd0zTU2xKq1rcSoJcdG6kychMxPefBO2b1ejKe+6C+6/H4JwMYP2KC+qC+udrtA+9oNrGDpAbPcoUoequUNSBqlh6T0ucI1sFP7Pble/RrW13nl/CXFxOqcTvv5adZl88IFaOX7IENXqnj5dVo8/hbncFdJHG20VjVYojE5S111fPFMFdc/B6kTjgaN7g3JlH3/icEB5ubrYqqwMSktd98+0lZaqxagARozow5Ytnq9PQly4FBfDu++q8P7xR4iNhRkz4Le/heHDg/7/8laLmh/k1MA+cci1T3i0alGnXVfXsh6sQjvW2MIfn4fWbxQtczhUkJ4pbFt6rrxctWtaExcHCQkQH6+2vn1d9+u3Xr2KAM+vRCUhHuzMZrVSzsqVaiIqmw1GjVIDdW65xTUkPojUVKnh58f+q0L72H/VVrzPtWajIRR6DIBzRrvCOmUQJPaRy+E9zelUY8fa2xKu3+/kyTOHcGxs08Dt0wfS0poGc0tbXFzbTgmZTBbP/IGcQkI8GDkc8MUXKrizs1VTo2dP+OMfVct74ECtK+wU5pNNQ7r+/i8HXPvoQ9QlfL2GwIh0V1gbz1FBLs7M6YSqqqYBu3NnDPn5bQ9mh6P1z4iJaRqsPXuqv8bNhe6pwRwX59/rjfhx6aJdnE74/nt1kjIzU10aGBsLN92khsJfemnAXmFS+UujoG4U2GWN5tsKCa+7ImQkXHKnamX3uEDCGtRfHbPZvf7g+vt2+6nv2rvJd1FRTYO1Rw913vxMreD4eOjSJbjXDZEQD2ROp7qi5J//VC3uvXtVk+PKK+Gll9RQ+KjAmJHf6VRrNDZ0gzQK64oi137h0dB9AJw/XoV0jwtUYHftqy7tC0ROJ1gs7vUH129Wa+ufERnZNFiTk9V0OS21gEtL9zN0aN+GEJbpdNwnIR5onE7YutUV3Pv3qxb2+PEwZw5MmaJ+w/xUrRkKd0PhT2o7/pMK7qLdTS/di+yirv5Iu9YV1ikXQHwv/+yzrqlxrz+4fjvT5W1hYa6QTUhQY7b69TtzKzghQYVweHj7jsdksnDuue7/eQgXCfFAUFOj+rj/9S81DP7QIdXinjBBLTg8ebJfjaR0OlVXx/H6oP7RFdonDjU9SZXYR3WD9LsduvVX91MugLjuvnUxTW1t82FrMsUTEXHmULac4ZxYaOjpfb1nndVyP/Cpm8wK7L8kxP1VURF8/DF89BHk5qrT95GRqsX91FMquBMStK6yVbXVqlVd35re820Kq4+px+pn3gO11Fe3/tDvEtVf3a1/3XZu563PaLW2vS+4uZaw2dzSO/cA1L+5pwZt796tt4BPDWFf+kdLdB4JcX9hs6lh7+vXq/DeskU1SXv1UicmJ02CceN8ro+71qwuzSveC4V71G3RHijaC6WHXfvpdBDbM5Leg+CcMdC9v6tl3aVHxwPKZlOXmrnTH1xWpq6uaI3BcHrQpqScuQVcXLyHESPOJSpKQli4R0LcVzmdsHs3/Oc/Krg//1xdCqjTwYgR8PTTKriHDNH8t7+2WgV10d66rVFYlx5pum9sMiSfA/0vc7Wou/dXj+07sK/F0Yv1Q5fdbQlXVjb7tg30+tMDtn//trWC4+PV5fTu/BhMJlswXoovPEhC3Fc4nfDzz/DVV/RYu1adnDxSl4B9+0J6uurj/p//0aR/u6YKSn4+vTVdtKfppXqggtp4LvT/H3VrPAe69oNwI9Q6m4br96Xw5Xooy4aff+6GXt98KJeXt16fTqdOsDUO2lOvjmitayImRvN/C4Vwi4S4Vux22LkTNm6Er75St8eOARAbFwcTJ6rQvvxyOP9PN2YAAAyWSURBVPts75djU90bJftVWJ96W14MVqAGqAUM8RDRHULPAv0QIArsoVCrg8Iq2FoGZTug7AtXCJ951FwXEhNbHrrcWtdEbKx/XnUiREdJiHeWo0dVn3b9tmmTq3nZqxdcdhmMGQOjR7Nbr2eAh0dNOhxw/CDs3wmHfoTDe+H4ATheACXHVfdDjdMV0rU6FcpWA9Q4wKwDR+MQLqvbGqkfulwftqmpqrfnTK3g+hDevXu3TAbla5yAo25rfL+5rbV9nU1vow7Xnbtp7XXOFm7bu29zr/Pme7awb/de3cELf70lxD3N6YTjx9XoyK1bXaF9tG6mI4MBBg2CW29tCG1SU5u+h8nU7NueOnS58XbiBBQVQNFRKC6E0hOqD7myGqpqwGJXf5daExkOXeIgIRF6dm163fCZuiR8fuhy/S+ZHdcvV+P7jb+307bAstP8L3Q7Xte1sCvsbsNr2vP+bTmGttZ/pr80bkol9cw7dYSubtO7bp06p/q+8WN652n3G9/Wv8apdzZ9XO/EGaqeb/j+lPsOvaPJ4ydjT5KA568Y8+VfO99XVaXWlvz+e9U1Ur+VlLj2Oe88GDcO50UjMKf9mrLUIZTVRLpOvn0FZR81DeRDh3ricJwe1DZb6+WEAOFAWN0WFQopMRBvhKRkSO4B3ftASl/ocy50M0J8rNriouv+Mthb2U4NPjvwC1B0ymPN7dfSY42+TylNga/dfI+2vMYHJZPc9Je//pfe0DQY6gOhuVuH3oFD53DdNzhwhLq+t+vtTW916tZmsOHQuR636W1N99Wpfex6O3adXd3WbfX7Nmy6po/b9Oq9bXobNp3rPeqfr66txhBpUN/XPV6/b+Pbxs9Z9VbsOjtWvVV9r7M27Nv4Oaveqv48TvnSWpo5jR3s8Pj7ejzEn3vuOXbs2IFOp2Pu3LmkpaV5+iM6l9UKBw7g/Gk3lv/+TNkPBZTtLqJsfyllhTWU0YWTukQqI3pQmXw3ld1TqT67O9UhCViIocYcQs1WqP0S9A4IN6gtTF93a4DwuvtRYWAMg8GGGCJDIDwWwmIhpCeEovYLq98MEBmhLg2PjFDXCYeFq0EfBgMY9KCvb22duu0Gfur8P0qHzoHT0CiADI1CR+/A6rTyS+kvKkQMroBwGOoCxmDHHlYXFgabKzDq7tffWvVWbAab65fdoH6xG271ru9r9bVY9VZqDbWu+3rX/cZb48BqLtxOC7ZTH9O5am/8OjrxhKoePQYMp902vq9Dh76NX+7uW11ZTVxM3Gn7GDAQSmiH3tuT+7r73jp0Tf4sdegIOxIGXhil6tEQ37JlCwcPHiQrK4t9+/Yxd+5csrKyPPkRZ+ZAdexa6rYaGjp6rdVQfVJN4m+pgJoKJ7UnbdhKa7CXW7Gb7ThrQGfToXMY0GMgRB+CwXAWIYZ+hBn0hOkh6VxIOd8VxHoP/xLaHDrsOHDo6ltaThwhDpyhdpyhDpxhdpxhduyGugAz2DhZd2s1WBu2WkNtw22NoUYFVTP36zeLwdJwW7+ZQ8yYDWasBlcgNg7MhtszPOZOWNWHS0jdV3P3Pf18GGFEEdXw2acGXP1tW+63Zd8jh47Qt09fj75vS8/r6r58gemwKejOf5hsp3eTeoJHQzwvL48JEyYA0K9fP06ePEllZSUxMTEdf/N9YNsNNb+ArQzs5aCrAixgqHVisEGoA8Ja+UsaCnSp2xQdEEqNPRSzDcx6J7Whdmr1DmwOO3bsOPQ2HKF2asL0VEfqsIc7sIXWYg2poVZfQ43OgkVvplpXTRXVVDktVFKNObQaS3g15sgqaiKqMEdWUh1ZSW1cBZbYCiwxFVRHl1MVVUZF5EksoRZqQ1ToduT3LLyVr7C6r9A2fMUT36b9QgklhJB27dtSiO75cQ+Dzh9ECCENrZdAZ6oyMcAbZ7tE0PBoiJeUlDCw0VUViYmJFBcXeyTEf5pbQ//4cBx2KK+BEgucsMBJK1TU6qiwQpXVjs1qwW61YLdW4bRW46ytQm+rJMRuJjTEii7Sgbl7FVUpFVQlV1GVXI052YI50UJll2oqosspDy+lMuoEVdEnsESXUxtTgS3mDEP2GgmvjSLCFkWEI5JIoojSRxJjiCImNJJofRQJRBJFEnXPEkVUw/0IIjhx9AR9U/oSRliroXzqVwghfh18Uc4owmnnTEpCBDmvnth0tnBhsKmZqy9aYrFYMJlMPJ1j5Fh1ODarOmlXfwKv8a0ePTVdqynvt69hqzjrAOYex6hKOUp1j2NYupbUdRafLvxkFyJOJhBVmUBMVQJJ5T2ItsYS7YwihmhidVHE6aOJC40kPiyS+IhIEqIiiXHEEO2IJtoRTbgzvMNBarFYiDjZ8oxETpxY6r4CSf3POpgE4zFDcB63t47ZoyFuNBopaXRlRlFREcnNTHvanr4wk0n1nb11QA3ttlTUbeVwKPxnvkveyO7E7exK2s7epB1UhZ9s8vqu5h4k16Rwdm0fjNaL6XG0Bz31KaSEdKdHeDLdIhMxhiaSqEsgpEtI474WzdQfc7AJxuMOxmOG4Dzujhxzfn5+i895NMQvueQSXn31VdLT0/nhhx8wGo2e6Q8HouKhz3AnW9jCu7zLv/k3+9mvniOKNNKYzq30pz/96Mc5nENf+hIRGQGRHilBCCF8jkdDfNiwYQwcOJD09HR0Oh3z5s3z2Ht/yZf8gT+wjW1EEslEJjKb2YxjHP3pj4EAXZZFCCFa4fE+8YcfftjTbwnAAzxAOeW8wRukk04ccV75HCGE8Cd+M2LzG75puExNCCGE4jchHoVvLXYghBC+QCbvFEIIPyYhLoQQfkxCXAgh/JiEuBBC+DEJcSGE8GMS4kII4cckxIUQwo/pnC1NNeglrU3kIoQQonnDhw9v9vFOD3EhhBCeI90pQgjhxyTEhRDCj/lsiD/33HNMnTqV9PR0vv/+e63L6TQLFy5k6tSp3HjjjeTm5mpdTqexWCxMmDCB1atXa11Kp1m3bh3XXXcdN9xwAxs2bNC6HK+rqqri97//PdOnTyc9PZ2NGzdqXZJX7d69mwkTJrBy5UoAjh07xvTp08nIyODBBx+ktrbWI5/jkyG+ZcsWDh48SFZWFs8++yzPPvus1iV1ik2bNrFnzx6ysrJYtmwZzz33nNYldZolS5bQpYsPLKvUSUpLS3n99dfJzMxk6dKlfPbZZ1qX5HVr1qyhb9++rFixgkWLFgX073V1dTXz589n5MiRDY8tXryYjIwMMjMzSU1NJTs72yOf5ZMhnpeXx4QJEwDo168fJ0+epLKyUuOqvG/EiBEsWrQIgLi4OMxmM3a7XeOqvG/fvn3s3buXyy67TOtSOk1eXh4jR44kJiYGo9HI/PnztS7J6xISEigrKwOgvLychIQEjSvynrCwMN58802MRmPDY5s3b2b8+PEAjBs3jry8PI98lk+GeElJSZMfcGJiIsXFxRpW1DkMBgNRUWrK3ezsbMaOHYvBEPgrFi1YsIBHH31U6zI61ZEjR7BYLNx7771kZGR47Bfal11zzTUcPXqUyy+/nGnTpvHII49oXZLXhISEEBHRdLFzs9lMWFgYAElJSR7LNL+YTzzYroJcv3492dnZvP3221qX4nVr167lwgsvpHfv3lqX0unKysp47bXXOHr0KDNmzODzzz9Hp9NpXZbXfPjhh6SkpPDWW2/x448/Mnfu3KA6B9KYJzPNJ0PcaDRSUlLS8H1RURHJyckaVtR5Nm7cyNKlS1m2bBmxsbFal+N1GzZs4PDhw2zYsIHjx48TFhZG9+7dGTVqlNaleVVSUhJDhw4lJCSEPn36EB0dzYkTJ0hKStK6NK/Ztm0bo0ePBuD888+nqKgIu90eFP/bBIiKisJisRAREUFhYWGTrpaO8MnulEsuuYScnBwAfvjhB4xGIzExMRpX5X0VFRUsXLiQN954g/j4eK3L6RSvvPIKq1at4oMPPuDmm2/mvvvuC/gABxg9ejSbNm3C4XBQWlpKdXV1QPcRA6SmprJjxw4ACgoKiI6ODpoABxg1alRDruXm5jJmzBiPvK9PtsSHDRvGwIEDSU9PR6fTMW/ePK1L6hSffPIJpaWlPPTQQw2PLViwgJSUFA2rEt7QrVs3rrjiCm655RYAHnvsMfR6n2xTeczUqVOZO3cu06ZNw2az8eSTT2pdktfs2rWLBQsWUFBQQEhICDk5Obz00ks8+uijZGVlkZKSwpQpUzzyWTLsXggh/Fhg/9MvhBABTkJcCCH8mIS4EEL4MQlxIYTwYxLiQgjhxyTEhRDCj0mICyGEH5MQF0IIP/b/yDpdjkUV5l8AAAAASUVORK5CYII=)

Identificamos a seguinte ordem de cresimento

1. * f(n) = $\log n$
2. * f(n) = $\sqrt{n}$
3. * f(n) = $n$
4. * f(n) = $n \log n$
5. * f(n) = $n^2$

# **2. Suponha que nós estamos comparando duas implementações de algoritmos de ordenação. O algoritmo A executa em 2$n^2$ passos e o algoritmo B executa em 64$n\log n$ passos. Para quais intervalos de $n$ você recomenda o uso do algoritmo A ao invés do algoritmo B. Apresente uma solução gráfica e uma prova matemática.**

#### 2. Resposta:

Sabemos que a constante do algoritmo A é 2 e a constante do algoritmo B é 64, portanto temos que analisar um caso em que n é grande o suficiente para que o algoritmo A seja mais proveitoso que o algoritmo B.

Usando n = 2

---

$2n²$

$2 * (2)²$

$8$

---

$64 * n\log n$

$64 * 2\log 2$

$38.5$

---
A partir do gráfico é possível notar que o comportamento do algoritmo A até $n ≤ 200$ é mais proveitoso que o algoritmo B, porém, com mais entradas o algoritmo B se torna mais eficiente.
"""

# Commented out IPython magic to ensure Python compatibility.
# %matplotlib inline
import matplotlib.pyplot as plt
plt.style.use('seaborn-whitegrid')
import numpy as np

n = np.linspace(0.1, 1000, 1000)

plt.plot(n, 2 * np.power(n, 2), linestyle='solid', color = '#ff0000') # red
plt.plot(n, 64 * n * np.log(n), linestyle='dashed', color = '#0000ff') # blue

"""# **3. Escreva um algorimo em Python que implementa o método de ordenação por inserção em ordem decrescente. Considere como entrada um vetor de tamanho genérico.**

#### 3. Resposta:

O número de comparações que ocorrem durante a ordenação por inserção depende de como a lista está inicialmente ordenada. Se a lista estiver em ordem, o número de comparações será n-1. No pior caso, o algoritmo de ordenação por inserção possui complexidade quadrática (O(n2)). Portanto, para o pior caso, a ordenação por inserção é tão ruim quanto a ordenação bolha.

O código abaixo ilustra e detalha como ocorre a ordenação por inserção em ordem decrescente de uma array com 10 elementos.
"""

array = [1,8,2,6,7,9,0,4,5,3];
# inserir a sua resposta aqui...;
def decInsertionSort(array):
    # Primeiro partimos de um laço exterior que ;
    # parte do segundo número no array, visto que;
    # se houver somente 1, o array está ordenado.;
    for step in range(1, len(array)):
        # Utilizamos esse número como chave/key;
        key = array[step];
        # Temos um número j que sempre terá índices ;
        # anteriores ao do valor key ;
        j = step - 1;
        # Garantimos nunca sair dos limites de índice do array;
        # e que só percorremos números anteriores à chave atual.;
        while j >= 0 and key > array[j]:
            # Ao encontrar um valor maior que a chave, o ;
            # movemos para a posição seguinte ;
            # e assim sucessivamente com números anteriores;
            array[j + 1] = array[j];
            j = j - 1;
        # Por último enviamos o número chave para a posição de ;
        # menor número na lista.;
        array[j + 1] = key;
    return array;

print(decInsertionSort(array));

"""Muito embora o número de comparações possa ser razoalvelmente baixo, para certos conjuntos de dados, como a que foi utilizada na questão, a array precisa ser deslocada cada vez que um elemento é colocado na sua posição correta. Como resultado, o número de movimentações pode ser significativo.

# **4. Expresse a função $\frac{n^3}{100} + 10n^2 - n + 3$ em notação assintótica. Apresente o passo a passo da sua simplificação.**

#### **4. Resposta:**
$\frac{n^3}{100} + 10n^2 - n + 3$

**Regra do produto**: Se o Big O for o produto de vários termos, podemos descartar os termos constantes.

---

$n^3 * \frac{1}{100} + 10 * (n^2) - n + 3$

$n^3 + n^2 - n$

---

**Regra da soma**: Se o Big O for a soma de vários termos, mantemos apenas o maior termo e descartamos o resto.

---

$n^3$

---

Logo, chegamos ao **resultado**: $O(n^3)$

---

**Provando** o resultado:

---

$\frac{n^3}{100} + 10n^2 - n + 3$ = $O(n^3)$

Se eu escolher c = 100 quando n > 1:

$\frac{n^3}{100} + 10n^2 - n + 3$ ≤ $100 * n^3$, utilizando n = 5

$\frac{5^3}{100} + (10*5)^2 - 5 + 3$ ≤ $100 * 5^3$

$2499.25 ≤ 12500$

Conclui-se que, existe uma constante $c$ tal que para todo $n$ suficientemente grande $f(n) ≤ c * g(n)$.
"""
package test;

import bo.ProductoBO;
import grpc.Producto.*;
import model.Producto;

public class TestProductoBO {
    public static void main(String args[]){
        ProductoBO productoBO = ProductoBO.getInstance();

        try{
            ProductoDTO.Builder productoDTO = ProductoDTO.newBuilder();
            FotoDTO.Builder fotoDTO = FotoDTO.newBuilder();

            fotoDTO.setFile("iVBORw0KGgoAAAANSUhEUgAAA+IAAAGPCAMAAADvMZrUAAAAllBMVEXe6vb///8AAACRmaEeICI+QUSqs7x3foRbYGXAy9VHR0eJiYnDw8Pd3d0jIyNpaWmnp6fSAADYe4E6PkwVFySuucbZh44KChj09PdCRlQjJjScpLLh4ePW1tgnKTbw8PNVWmnH09/XYmfVNDbbo6zal5/ZhYzcvcezvsvcytTo6OopKzjVQEPCwsn4+fuztLwtMD7ZiZALYpZ3AAA+XklEQVR4nOx9iWLrunLkOZYsy7uT9zIzySSZfd///+emqrvRBKnWYlvysVyoe48lkQCIAlHoBiQ2fv0eGBj4wRgSHxj40RgSHxj40RgSHxj40RgSHxj40RgSHxj40RgSHxj40QiJ3wwMDPw0zCS+fxA4cOqnQIBiAU3WShgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthC+T+NPN02eLOHqFz+W/qs7+8ro4cPO8J+XzYV5nYP1YlPG6rN8X4uFx35nnva30nlKuDHsk/vL0++Gt7gkd9ZNE9XxjBe027gvW8x9OuQfPXPl/OXqhZW0eloUfQUeRFzw4IqFKXtH2ug9V9+/x1vF6mbX4Hrxahtdl/3uEpKLareoveH1EG8xv5BIL1ofS+qU7+LD9VN2aoxK/4JAfPTQ6Xo9DEl+2/k+XOJoCKj+LxPfg+YadYNlV90j8pLH3fFb8+N19vnmwPvz48Mme+m6J7wHzRrVvfGx7e8ExSvzt4FA3Z+135Qy4PiuuJfE3/8q877yznvD08niDvmDJcDf923W3ITzlZ9CYT/bCcpCeY+pDnGDy7ANT/gdmwPkuNRO3G9Mffn2EE/CMI29+Gl3KJI4kuDWeBFdggXihH3BUPzsSZy6TyOvNo1F+xBHXCyyEJX8xY4SqU6lIgRenyASWGUdA8MXbrBUQTELi0SpuRFljnLKWeEC/Y9s4Kbo9jybarmJ2IpqoSfzN2uvhLSR+eIRcsH4mn1mj2VXZ3E8oDKc7rn5Vv6XkG8MVk7DxSSv6EG+u32q87M0bGay9onXt/NSkD9YwU6Huu7DMV7w+ISHvPvsGaXhZXfJHloaTfhNbW1vx3vrRP3nv2Bz8iJfumleI2oo/4WbO3a+5xNG07AsmqkckxM3ni/VQCgtN+Gr94ffTK1ua7irF8ID2wwnAupIh8rs5sxvfp+7G3tnhV7x5tcFkJvGXZ7w8RxIe4p1+PG1EXkrcHD3Med/8LrM0ys2kiWty1EelWQ/Star8fnxL7nhln4G4reC+gMYEMIlHq7BEtgsJMRVOvTBvI4WWfWFT9RXjieYMNIk/8Q2uGhK3rn4y65dH/s+8/tmvyub2S7NSjSsrSpeBfOxEG2OCLettR15R4WD0Ch3uyRsZJm/shQ2DBuyalN2SxbBQTkKeW9H2jyOA330rFrfGxlzvPtHSJNRucLS1tQ9bv+u4bFzmZGN/xr368/DmXEr8DTfRlLhP4mYl/NU7ptnMdio6nfUva2lrI5y1vpda5uCIDuX5/UaYXPvUORenResOm5VgSTfPMyvu12tJzF1ENU6ali9mpc9WfVzDLuMuAs1C9I5nt788xsM4P40jOOWVQi+hxG3G2hXQmDSJR6vwsF30Adbe5ZGd6+apDXQYTfuK+XzKer1XG0mZ0y9jSQ/20KXEHx594I5Gi6u2hrSPuG7TiDd+awQuCMRtaY0/XRtZ/MPevJFhmqVH1+iblIgbPY1cKJFEvTvG3fdiLY1fNgprDJyP5XVPqNW0ddyup+2sbV4VSolbX5kvhRUSj1eumlEQzYozDd0jtJS3DCXOlkZbhXkBworzvnt+OkU+qM5Sd1Z8dniSuPf9kLj5t53E+eqG0kf+91hxqz4KXUjcSPngz4O2vmUzlljWcu6tUsyMSkXDRAGNSS/x0DNdeA58zYqzTCcVK+OUeF8xS5GdModUXj8lfsiH2bXidjnefTZaXHUmcQxHztUUE/IIM09K5pKj8a0cbxQn5cPR3rwtg7VXqo6WfGpSb6D+OwQvepJ4uB+4Fm+NTVmcGC5iF83F29bWKIKuCi/WdVxKnIdY8svOuvAVobbi4LZYCDsgcb8dbC+b/IZN2W/FvSgfGXNoJ5rTvWvFXeK1Fff76BL3meSuFZ/N/U+WeG3FU+KvD3zfTEXmcu69xJn7eSbxwoo3iUdf8mEvffcDVtwlPnPU8dE65gesOC42OcpotPdZ8Vjn6xrfwUHmmBWHxDNDTD/C8PZNSi9/ZsWj6B2JH7TijtbWPrew1u86bt/TjgyT3xveWjsSxyxm3i9KifvM2Tpxs2HNy/v94B5qPxfHPGiSuE3a7eakfQ2jOEtNzObicbiXuE3jQuL0BiaJ+1zcanZ8ibeei5uvXUocxoZLRT4Xj/o9vgX3ucTxqS+gMQF6ifuStnXc9kVUc1VJioNiNxePinn/nc/FObVBMR+Zi5s9y+4cTirm4ilxDh24afP5ND24lDir9xZz8QBq8sxFO5uL7807ZWiDOiccPqS1JvXlS6+vzcWj6JnEORf3Yn0unl/5cXI/jfXTelAbGLqO+5hz8eZuxsrm1aGWOBZ4oPKjEnf/t7lR5vS4gOF8e+Pa+lIsbMaabxqJ9qCb54+lT7zMUhNt4O0P9xLnCi58KxYMX+Khzcbaoi7XY075Xn1nRd3XCvZK3CersaLOru/rxc69k7gvn88KCCZAL3GbqsRUw5zWEHCQIgsXbV8xl/hsRZ0XiVPvWlFPvzrmCt5odnCSOCvj9yJsOvjGfQiJ23o0fV37xsWubV9sWH/hELI3r2eYvm7glxAxF2xNakVEnW2tP4qeSTzWxdutCX5cZo+LxleD3tbxrYu1fnRcfmHE+vL6NmDa4umPkvgHfgTVLY1cKY5S/EI0Z/dkHHDG+6/ed/E+1l97h697Jfu74GwSj2XlK8Z3qny/fHZahv3DweFihsR/Os4m8fjVyhXjO0ncHMz3fFWzX3tn/Y36kPj1YTxplhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayV8QOJ7voKdh5C4Qmh2dk3WSviAxPMxYP4SsP3sED+8vuon7gDNzq7JWgnvl7g/HtlFZoofSB75icX3x7XX/2PQZK2E90vc4yV1T2e230Bf+2+RNDu7JmslvF/iFgAnHs02NIlfezw7zc6uyVoJ75e4Bw/sIjPZXBzy/pNBN88Bzc6uyVoJH5C4P1I2PSrfrHhERrhaaHZ2TdZK+LAVnyIzpcSHFb9CaLJWwofn4lNkpjEXv2ZoslbCx1fUMzLTWFG/ZmiyVsLHvhevcN1RnQDNzq7JWgkf+3VbhS5k7XVCs7NrslbCByS+Z1lt/Eb9KqHJWgnjSbOEAMUCmqyVMJf4wMDAT8Ow4g0CFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiSdOonjtv9Ldwflv7OFtEg/kaxuSHsAZfl+12HgP26Qe/VXmdT99sUfiT7bDrKrEuaHYnn4KidvGvnNccR9YbD6MXff9KWFE5sMm26coapnooxI/ZfRcXMt2Wt8pBzQO1Hsu8ZN+dr24vdx2/IpQS/zhYXnftCTOrbDrXlL3w58h8die3Jm/vcT25EdxLolPG/p/xopnSMF9mEv8pM10r/j2AvscdXmJx57+7Hc3eGW35cby0e8Z7wZij83qaTd8M/vrc+N3Je5G6uEtqMZY9/oIKw96OI22AGMc5t76b/B0bYN9i/xjLzgfu+6/PbzGxvveNtyhn0XRQ4hfZfghz8GIgNagsM7IznZ/YIIYNqJC3uaRBLeH+/xP7Z4hBfk7a7PRXjPeKrtTjxZaNLKwrIdZbZ9eUN4jjuBAK4ItA5qogydhm3lFrwFD4okdiT9FOGnr05TwM7qTdTOGvLF7j38MdsMM7diVYVfiT0F/IXEwp/htsKOOkMpzWFd5YVOhQXACKcyBRsyQtxA4m+/3y+8HttATioIwkdIy+KFmxXkxaPDZPG1eimMsknYSf6L2eAssCSYTFrvAi/C74Gj6bDXjreG9euEdpbgtlccS7mrLMAgYrC30SSfxRxJgELMY/aOi1wCv5ZA4MO/suOX2vA36lZmK6SOapu3wb2JA7+Pru3f9/x5YzMWh4Sd2YXi6c0e9bwwbyaA6V38munlqJ+wQXpvP3rnDXMyIopprHpOfHCKjHNc8GvTtYWbFvehMYrmz3aeQgmnFPZmliKBk3SScn2a1tdNMhxborbg3QUsyVfD7Y0g8Me/sdCjNlwyJP/j8LiRuZ0LiHNMp8Th2ZSisOEia+duV+EOTOMGhjX8sEWVFaeItJc7EaJiUeAu1b+3pRbkVj0Mpcb7xy3cSD/VFhXhbeolTZ/n04xRSsOnTaxYSR542A+sk3td2krgP6k3inIz1Er+er1eGxBM7nb31mybxhRXvJu1pxa8PlcQfX0jmiBXPqS8TmbKOWnFziJvEXdpx6LAVf/ExItqeU+K9VnwKKUjhIlHUbGbFfWw5ZsV9g5+QOGcgw4pfO3Y6O3tCJ3HORDkjjbl4L3Ef7v3YlaGSOEwruCzn4k82fzWWuabVuj27/Bv19oq3bS4+hfX7Te/mhXmfmhWf2paHZnPxTr9N4mzcWAexOnVJfC4OHXo9p5CCtngHiXvNjB3TYJ5tup4kPqttL/Eook3JOiveKnoN2POlGR2ZmcgVJd78uZA4PcRHuKptRT36jYeqRC+JY1eGSuL+1f9C4q9wVd0gxnfPr1yrZkLb0Q79BS4z/W5aXJ8OTxK342zPFzSgSdzaNg/ll2YoOEaMmcTt24xoe67B96MAHXe8z2852wOU/AbAVkitZs6O1+SQjCImic9q20u8FYG8JNBZ8VbRa8D4dVtCgGKBU1mfOYR2c+kHLo4h8YQAxQJ/SOJmCa90+eLKMCSeEKBY4A9J3L6AGEb8KzAknhCgWECTtRJG7LaBgZ+NYcUbBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKuIzEz/0l6pdAgGKB80v8Q79Ze1+meWilU8Kv/ZTb9QHUEucPiOcPyi0eK14+M7l4Ov4qG1SAYoGvit3Gwg802T6J2yO6y1r4o5zvCr+2uF1TDImfj1ri9kjtrOF2n9E4hKvs/wIUC+w+hnKJ2G1PNmLG8yYV9kr8eA1OCr/2U27XB7DfUZ+Pczs9IcKW2aeXN94hPq9jz+PevLBB+fGq2lWAYoFdiV8idhsDO80ev43oaS9o4swUrRt6d3GHxB9f7er26fXVnwYLR8vDr8VTb4y89sqwbvYcXItXwWBSuE/0CDIJn027mvBrn8JeiS/cn93+72HL/NbYI71sUEbb4mOVDOnBJw+vKQiKAMUCxcOk54/d1p68nyQe0dMYSC0zReuGefFAEU3idnUvxyNPxQXz8U8PmmtPizOsG4YQxK1BYIhJ4m+sNO9aC/RwPeHXPoW9Ep+e+q+mbHGv/Fn99hztFB0nguJc16NEAhQLfFnsNl/faRIHInjU7LnSOIWLxTubi8eigIuWMWCi0m7zrfB4jtvOWIEsGVFbeivudW1Jrilwy6ewN+rLYm60a+KmmEZ8st+f2ocwEEvP+z+TXdUDwQIUC3xN7Da3tyixj1+dEo9m9NYN1U6azBeXOkqIKBzh1ltxPI9KLyQeIbhC4hzDeolfT/i1T2GPxHccmL39/+2FUT44Ylu7X7GJE6BY4Etit8V0hnHbpvjVSyserWt4QZvbm6hBUyrSeuTrFpINOGDFEY1rkjgjLA8r3o7u7umzt/9jFjUFyXxl23PW1Caq1zRGClAs8DWx23xSzhJtrS6jp5kRjUzRutEBI+dC4ojaZmG18oLANBcP976XOMcSVj1GZOTOJFcUfu1TKCXujtg0gu9O2V6n/m9BsHh7cIJ3iFtY0FHb/W79m0OAYoGvid3mXcpKZTi0jJ5mEm+ZonUJ/5INMOc93AJe+o0N7gOEXbBJ3GKr5ftJ4hZwD+mobybpJH5F4dc+hfED1oQAxQKnsv7aL5avNJztt8SQeEKAYoHvKfFrX8T8ThgSTwhQLPA9Jb74ynbgExgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwpB4QoBiAU3WShgSTwhQLKDJWglD4gkBigUuwLrbm/jLcy/RdjNueHh6Pm0vpW7fZdTomreYHhJPCFAsMLG2nUlta3/uPOxb/B+EbTG8R6Sxn+n8UsTRCi0lvrsR9iEsN0NbSBzbjT9gk3PfeXaRc37dTtQo42u3ezovhsQTAhQLzCVu2yw/45jtCvxB7LPDp+02+jkrfkTiL288cIpgO4m/Pv4+q2fxxRgSTwhQLDCTODfcd4TEY5tvmD1IhxZ+2tEbYsIn7uv9ZqkpLqZ4NpFyy37fox67hodaQuJMxNHk8eXm6fEVp59wBAeikLb1N2ToSZCbV4lCuHM5Ej74pdp28L7N+c0jtyPHe8/Ol0dWNbY257s329zcJc7iUSf79PBIUs7GXrrLYnvz2O38KjEknhCgWGAmceywH5hJ3E0h9R9G0UQG2/bk3n1T5xO37H9oEudxFIlT4dC7xOkQ08V/5cdHvHmEjFh2J/EHjh0QnyVhgTj1YiXysKXgNby2fOGIYufNirfslCcqTBKziUOTONI8vqBC5jqQGv7nJ1T7GZXqLnvNGBJPCFAsMJc4+jNsInt5P29+MnGaMFz6oWNK3KTTrDgQIrXE0M80y/e5+It/aJKkrbRh4+VpZsW9zJbEnGYv396iCJby5MWzcpwu26d01JE9TtihmcNuc3GvIyclHGY4yti5EPvistcM5zUkDghQLFBYcXbx+Vwc3nEsUrlBRgr2f2rowRzjkDiTTBKnJXVhh8T5kctdJqCFxNPbZ256yLxikzhfXYL0xFmeSTxciljGw8VDkZGdYwUlTlKzGX6z4lZHqyuuzdJssfHZho75Za8ZQ+IJAYoFZhL3VeVdiZuX3i9SvbxRqaHZV5MtxEWr3VlxnDCnN624J+eHXSv+1gox94Ae8n4rHqU0iecqHkYoSxXZ91vxucTBDWeRgtOFYcV/MAQoFpivqHOK20s87G/4r5MhxEJViotypUmHxLm6lhLnrNYKep5ZcZ+LxypXL/EoJGYAT50V90mxFeKewUzi0wJCc7cjOycRtOw2F++n1AuJ/37hhNskTjcBl+fC4+yy14wh8YQAxQKL78XNEY7l7ZQ4D9LETt+VP9uKNaQUi9VMECvZKXFO6ikbHOslbqXh3Y7EoxDmxpVe+P31lKQ5+/Y2lvmaZeaFHmz1wFbRYco9Owts6+SzRTObcvhUwST+GPaeJ/i1Ia4BN2V22SvGkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayXMJT4wMPDTcKoV//XjIUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwhklfrOZfby7vUyNLwYBigXOLPHt9t1Zbu/2nVnfbw608P6bcX9z/xNuzZlQSzwCc5QSv+U6/LKYOxyJJl/d3F9n/xegWKBjTamtSB0s13x1lnE0PxxEk/jNXt3+Wq/mn/dK/G77a735yM3Y3HxkqPmpqCVuj87OwlXNe8J2/QNNnADFAgvW1Ms9js10uMHR+9M0c4K0Tpb4zWaFm/CBm7G9+3XiiKSA/Y76PJjevCdgmERHuLGhGqPs9hfvxQ3H+u4cmpyvVyMDAYoFZqypZUfo0I3xKhKRfehqa6zxF62yusXrasNGgsTRWMjL/HgXLYNzPGjOAI3yqvkFeLlla/NjKN3LBO5vNnch8XfejPWvuyhs4IDEW1CeUuK3aEfeM9zwLd7e3luT837cWpOv79Dat/jHm30tLpMAxQIz1mTqmEn8l3vKHABIHaD2thsKCe2wQqoVmgaahEA35joj/5atZ8XwBObHYXdZNOfYuBhPeG64CZ42ypygdDMuglrifFB233Ib50YcdznUwi3z22ZNjndob//fHCfznSzhNUCAYoG5xCEPko+5+JQKB8MJd+1PzjYOkj4V/OsWuo40kcCdcGskvPUBo+VFtnbCkk0+/szbV7oZF8FeK95CdVRWnIOurcvAZXLXrjU5pnFscrYym5y3Ksb97w8BigUKK252cTFhhnmmC+0ON067v86BoJe4DxKUOvMztUvcMuKt+fJWNMuCxC01JM5DMZn2Mico3YyLYP9cfB5PfuHF+n2dFj1+wqgqQLHAzsC2R+LQcGdc/TTaaG7FQ+Juxelud1Y8Lufqp6NfW/Eoc4LSzbgISokzHvYUtquQONdffDi3aVI3N9pae2PE3uTcyO7yFUCAYoHFwEaldhJ3K8xZNb6mmhbjbIl7u2GOpRW32XVT+b3n55Q7gIPMRTHerlHiBgW3ubglijInKN2Mi6C24oyGtfd7cTahrW+41wbHCvcoVjjxwibHCup6hXvBldSraXEBigUWrM2n5orXYrnNJubmLLvMbV2b7bO04ndoLH6vvrKWwddXBN/ebOyAlbJhk3KYwOW2TMPL+jAQZU5QuhkXwfgBa0KAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwpB4QoBiAU3WShgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFngn63dv7fv+vYA/tHvwtPdpw2KfcexxuNxP+QxXXt9vpo2Vj1Wq24MZuzx2ny6LIfGEAMUC3c6ktn0odiH1jrnmxsA73fCoCpYJ9mfwzczLEmwX4UOwjVB7HJX4zobpJ9T96C6nd9tf64033M4p7onslWpEu9ZE5Wbbr14SQ+IJAYoFFpsP4wB38GZ3hyguKvHP2NL3S3w3wRms+M2GWdhw3En5HVYcGy7vGeDOjyHxhADFArsSd6NzuwqJu+LNyKMbhwq2d/jIzb7h/9qW30zEzb25UTj3/vZ9vvnCDH5ws77j/uLe1bdbapA7lt+bGE0neQnfgZxlTDuGs2huYo6L2X7l95GeL3dUE16bqLgJOUv1Hc1913J8pr1FEaC4tqqveeTeRwNUgFdm0SgkkvhVwwHwCsDDcLosdUN6rDqL4EVYV9t7ve2Abrufxznk4ite1r/ugtXlMSSeEKBYYFfim+iyc4lv8QLfskkc3Z5DwdrEARUhj3uelmBN2dzbCRM8CkQxG5ebncJl2PNNkk1h7PVrF5odh4JaSebuWuFeAbPiLT1ObJGUhjR8YlaWVcPZ5qGzRFIxB9rqaGPTimk7id/jFGXrSdACJlEbOKIC95TobCLB9mLRPMh6sNHujQX178WjJsxoM5C1N8NXYUg8IUCxwGIufh/agyc5d9TZzXGiSZy9FAmoH5Mbjruvms7uzaadsEPIm66z69gkzmElrbgXnBLnCDH5u5YAnrGJOB11pI8TnswFHZW1goMDDnmmPiVpbLwmzYpHfVoSK8/rFtexUtA8E9hw+Gy5UWIMCMHCq9FqYpX50HrixzEknhCgWKCw4ujX7McLiRtmEr9tEidwHI5y9F9zpCEGvKXEWQpKTImjWFzMPtKnTYnTN58kTqsZJeUIhLdwfptaPT2q4cK1+YWR4FsTFtFJnG9Q5bnEQ4AhcXrjvcT56v5JVMAl3hti5sRBeuWsTzgdwQIX5RXYKpQ48y1WCS6NIfGEAMUClcTv1tT2rhUH9llxB3xUJqCHfciK40SbAdO9Nenh6rTanRWnTxslddVzj9mKjvRHrPhU/z1WnKWlxDmuHLLiQXcpcdalGWev7rDi3xACFAtUEoddRufcnYsDORenOQ1FNYfaOrGvLdGmwRvY4m2bi4e19kutUVp8pFXlxB4S5+paStwu2EqKqbCjSTDSc7p8m3NxL58z45iLd0OUzcXbNKCTeKtADEfbTuI+F8/FgL0S58mYoPMq3VzceaP0Tc7Fv2ylzZkPiTcIUCxQSdyn1bsr6uijacXhJPswkA4z/9oHGCskhYtLF54uKl9DTI4Ve3p40jjBJWrMbi1ZStx97CiJcBc6ls05KYj0rNmKaVjDaVoR84C2IO+a9SX4HYlHBewbMJTZSdyuF16KV6CWuK+n+eo7l/NzRd0W6W3CseaEhYy/VuFD4hMEKBb4GOsv+93GwKcxJJ4QoFhgSPynY0g8IUCxwJD4T8eQeEKAYgFN1kqYS3xgYOCnYVjxBgGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1Es4o8fY4fqB7hOEopkcMTsMpUXreDQGKBc4s8Q98Yb6/ZT4aGe3sN+MQjgahmnDC8yceR+as2Cfx55uXPRL/QKSqo/hA/y8i6XxSFQIUCyx+o25PRPLH53zNJ8gsOMtJxTWJH/gh9pLD3pb5cGS0o/iIxHcHLw/tEL+gPwV1VLr+ebhLhG3cJ/GHh70Sf3+kqqM4j4k7n8R/KsUCC9bUC5+tnF2Ij1rdn2aeT7DiJ0v8w5HRjuI8En83agPdS9xHtfNij8TfHt4OSfydkaqciBkCfxypi39lT/n443hdeQAeFfbngiJmVzy2w4/beAiKZaK/3LqR4Wi/asc+3dl/JMVjrOOxSaCFQ2J18zlOViI6IB7AYqQnD7Z2i9cVamXPb7egbh5lbWoZHDASziH8gmXLeMmuhI9HRnv/zbDxgQ+k3iHDPdo/Ql1weOEhdyb4XKi1gD1CFw+R9omIuy1jyfljbXx4NRqkxbGzh1ozlB2pZFg5HMPTrGf/aXAt8eeb54MSf3+kKj7bv8EQxV4wi3/FE/asrke+i/LsBCmzCeL5en70XniHdLgpzMpH+24Zqc9jGOSxT0v8R1I8xjoeCgdmErdnr92Yh8lhZ91uMnga/5Ey2sq4WsiYLVsvG4A1dhGwaM6xcbFly7BkL3PCl9yMlLj98zvSLmgxMtyKZ2S31a97i1yTpUQiG595BzEAeEQ73kiWlnHsnAJKYyg7qyabNI5dArXEHx5/75f4hyJVuRtlJ3Czu/hXdoIhP/gpy2uP3iNzH9QDfkyLN9KKj6x8LNkCZsaxT8/FfyTFoxL3p68pmvkMGAenUC8zZzse8PYwLOjrXTiYrGarsQ8YLS+yLVum8om/5GakxPn0uj1SbqMIP5u0G3svMxzurpSWaLpAu7destegPQnfxaRBk/mD7X7sEiglTnkfsuIfiFRlb/1EhrizQ3aCjcUbjzxpniwNMrSYXdb/b/1GRf+3M9H/Y/7Yjn22s/9MiqdZ8XahGRAngdERYooQE8Yp2JpLPMKwRlC3rGbW2Hx5K5plof8vWmYqc8KX3IxdiSMOpF/Q1QsnyuJDewA7r2lXSkuUIaQhcaJJPOPYtWAXKMUlnjHs5mPqGVFK/NUv+LTfUX93pKpqVPUmP8nExYWiMXsT102d08SdY+HpR1I8ZWDbI3HUtTOufroLtjaTuFtxutudFY/Lufrp1NZWPMqc8CU3w0S7kHhcsJd4RHbbZ8UniYcVnwaPpRXvAs+mFb8Q9n4vfnAu/v5IVZydtLkRT2ST8wSnLz6rwRRmmqhy7ulhsrv+z3SM4h0T1b7/87Ud+7TEfyTF4wNbxC6dz8U5q8bXVNNinC1xby3g+tKKT0Hd8P+95+9qjIPMZRGjGN143jJRi6UVv/zNIDWbh08Sbxds6mWVI7Ibr9PPxT1fk7gtiHoQ+c4/yDh2EZVukrhX7txflU34mMQ/EKnKlz/pkNjK5xT/isuKdE3pA0V8regXjNuVzlHr/7b3BfyjttwcK5sRgYuLF9Oy76e+If6JFI+ztppwxWux3GbMzHd1mds6dBdsLSUeS8vIb4HZPL/XeIrUZnudcJhYtkzEeTtDZLR33gw2OWYfvcTjgk29+Air7ZHdfLnexqoIJddb8VhC9xlHk3iLYxcr6qhVxpa+tcFq+jLgzPi+P2A936LxiRCgWODrWf9wfNmOo6diSDxxMYp/899+/e3f/O3OvyHxH4kh8ZPxcyT+t//zP/7Nv1j895/+w/8bEv+RGBL/vrgcxX9f2PD/8p8vdrl3QeDGimNIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwpB4QoBiAU3WShgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBd7Juu3XebkMH8gBLPZ4u7v7td6/DcVir/737Fhx1j3AuWXiiTi+h12/5e2QeA0BigW6bQtjk/PoKGtu4bnTB4/qb5lgfwbf6bgswbYYPYQdVc57N3bzxj7itsvi7ibKvhNhtynjpSW+mwfbvOYe6Kch9lBdoN8ietrveEh8HwQoFljsTIoD3pVWa9/hfIEzSvwzVvyIxN2isSDuNbyDL7bi57D8tYHuJO6j2pD4QQhQLLArcbeut6uQeDMeMPK+7z+xvfMddtewlLbNLhNx519uxsstdn0TYL4wgx/crO9s53AbOLbb2Ez5Bpt7x9WxA3BcwrcnZhnTdsIsmjsc42K2mTF3BGd62zjYdgDOHYxvt9z02+pKFfAE3vp+xLYbeKu9FXcXxTal28bKdjmetyr6Ce5THDsas2grr+1rTHI3MKTWEn5BOxTOhNfbT2EH+XmjxH7qqLMX7Ezhb2QW8rONkZ0im51UrIp+7G61rwMPiScEKBbYlfgmNjOfS5x73Mde4tbr2LXu0elNUL61uHVU19V97qJvgucm2txQ21LYKVzG9v6nJJvEMYHmRuIhcevyrSQTlBXuFTBhtfQ4Ydv/c3joDTKT8gBHGTBhOas7kzj1z9qDoW3tjaqCnrvPxvT2nh/oAvBk7O/PFxJOOiwvJQ5yUCiHyOmC3IKd+8EzM4aLOLXdGMWpUZjISOHwmmNCzFZwPWvn4McLsDm8FmxcjlHt2FhuOw4BigUWc/H70B422Z876uyFONEkTrEiAfuYdXIcp8Q6N/tm007YIeTNjug6NolzWEkr7gWnxNmJJyfVEtxsXMTpWyN9nPBk/eyU5q0ZcmQI9zzsYdQ+znl5fiH/awWhaBvvnFPfBHj18iaJRwpvOR53XquJN8ry+i0bBYlaUTgehLxkr0HUum/2FQccuihxbEj8OAQoFiisODoMu9dC4oaZxNExvTMTtE40YtF16Txieui9maW0Lk+gWFzMRWHGL65O33ySOK1XlJQjkJlf/HFJenrTByVu84vw6olmK5kMgxfU0kvca79G2SZxnnKh+OjBE20AiYrzBCUedLy8XYlv2wUbL8/OQ5C4cVk2itfaisJwEkxbyY0fJW5nQuI0+TEL2V1VHBKvIECxQCXxuzW1vWvFgX1W3AFXlgnM8TxgxXFi8i5vMJ6EwUShnRVnt42Suuq5y25FR/r9Vtwc9Tz2CSseNa2suAl/KXG/4Ezi8FwOWPFJ4s2KT4PH0opH5VLix9blh8QTAhQLVBKHXbY1neVcHMi5OM1pE0J2MpuAeudc0RvgNLNNO0MFfqk1SouPKMImnK6myYrbBVtJMRd3tEl8pOes+Tbn4h01X9Ty+W98SdfPxe3SzLRuc3FPx7dtLo4Tk8R5wmbbTifKg3Z9Hj5JPApq6jWt4lr3yMjrdXPxzoUhWQ6svrjQSTz5+Vy8l7hXzo8NiR+HAMUClcR9Wr27ot7Wgtnz4Iz6MJAOM//ah1suCd/CJaULz3ksXzEMTBJf0UKbCbMTXDmG22vJUuJ0P7MkguvMsJ3uuHNSEOlZsxXTsIY9NaurrW/5RAIFxOhxN9We70yCPm9vC+eeia7CJHFWyUcwXwP38rgKjq+reonHBVO9t/YBmex9jGJ9ozSJk20ybRJv/NqKus+hwkfxmUuu+Q+JH4QAxQIfY33UOxx4P97z/fw7MCSeEKBYYEj822BI/NIQoFhgSPzbYEj80hCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFJ1n/9uz9dgy/EkHhCgGIBSdZ//YuQxofEEwIUC0iy/utvIY0PiScEKBaQZP3X30IaHxJPCFAsIMkaEtfR+JB4QoBiAUnWlLiMxofEEwIUC0iyNomraHxIPCFAsYAka5e4iMaHxBMCFAtIsg6J/28JjQ+JJwQoFpBkHRL//W8UND4knhCgWECSdZP47/8uoPEh8YQAxQKSrFPiv//xL3+6LhfHkHhCgGIBSdaU+L/Cchvxp+tycQyJJwQoFpBkDYn/q3/5f37/5V//6Yp8BYbEEwIUC0iy/isU/nf//Psf//lPV+QrMCSeEKBYQJL1X6HwX3//v37/vYIZHxJPCFAsIMn6L1D4r7/7h9//9D/+dE2+AEPiCQGKBTRZG/7+n37/3z9dhy/AkHhCgGIBTdaGf/cP//a//uk6fAGGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJc4kPDAz8NAwr3iBAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKZJL5aHz5/d3u2Gl8MAhQLnFni2+27s9ze7Tuzvt/sadR33Iz7m/srvTVnQi3xB661P9USv+W5ZTE/of8LUCzQsabUVqS+gbr4et9O8Wh+OIgm8Zu9uv21Xs0/75X43fbXevPpm7G5+ci484OwR+KP+60478h22cI/of8LUCywYE0l3+PYTIcbHL0/TSYnqOlkid9s2OafvRnbu18nDk8/FB+TOEZGdIQbG6oxym7R5Hf+CaM/bjIH3pWlwO20hGhyvn5nGQhQLDBjTS07QodujFeRiMYcFp7YGlH8hdZWt3hdbaxZtls0FvIyP95FY+AcD5oz4A0XfgFebtna/BhK9zKB+5vNXUj8Mzdj/esuShbFfkf99YDEb9F0bE3c8C3e3t6v0N7sH7cb3hmk4gfkYedY3+HYLf7xzn9jl0mAYoEZazJ1zCQOCfEvCVNsALW33VA7oM6WWUGXbJYt/q2QDvm3bD0rhicwJWZbRtGcY+NiPOG54SZ42ihzgtLNuAj2Lrc938ws+XyiynGXQy3cMr9t9gkTJ8J6R9wl3FjrFBhVzXc65mD9SQhQLDCXOBRB8jEXn1LhYDjhrv3J2cZBMqaCf91C15EmErgTbu2Ctz5gtLzI1k5YssnHn3n7SjfjIti/ov76sNeKc9C1dRk4Se7aeZO7r8TRk6O8J7nf8C2bnPctjMC3hADFAoUVJ4PlhBnmmS60U5/UZe0zSdwHCUqd+ZnaJW4Z8da8aiuaZUHilhoS56GYP3uZE5RuxkVwQOIzT33hxfp99TUR/m1NHtMwc55skeaKRlUBigV2BrY9EgfNzrj6abTR3IqHxN2K07B2Vjwu5+qnJGsrHmVOULoZF0Ep8Seo+2nvl2a2OtKmWTZNwtyoNfkGLb2y+2Q95Y5TJE6b2tzIbvn3hADFAouBjUrtJO5WmLPqu5tuMc6WuLcb5lhacZtdN5Xfe36fLhtwkLmov9s1Styg4DYXt0RR5gSlm3ER1Fb8Zfm1+ELivqThPhIcK9yjaHL4SuvblZ3a0hnjlzBYTl2vcGO4rPqdW1yAYoEFa/OpueK1WG6zibl7wm2GvLX2WVrxOzQWv1dfWWPgGyuCb282dsBK2dhKOLLhclum4WV9GIgyJyjdjItg/IA1IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwpB4QoBiAU3WShgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLvJP1u3fzff/2vx/aMHja+7RhsbU4Njhc7qd8hiuv7zfTxsrvKqvbkBlbPnafzo4h8YQAxQLdzqS2fSh2IXW1rLkx8E7PO6qCZYL9GXwz87IE2zj4EGwj1B5HJb6zYfoJdT+6send9td64w33CYmjprO9WM+MIfGEAMUCi82HcYA7eLOLQhQXlfhnbOn7Jb6b4AxW/GbDLGw47qT8UYlj9+U9o91ZMCSeEKBYYFfibl1vVyFxV7wZefTa6LnbO3zkZt/wf23Lbybift7cKBxJYmtvvjCDH9ys77i/uPfu7ZYa5I7l9yZG00lewncgZxnTJuEsmpuY42K2X/l9pOfLHRWM1yZkbkLOUn1Hc9+1HJ9pb1EEKK6t6mse4Y7kXgFemUWjkEjiVw0HwCsAD8PpstQN6bHqLIIXYV1t7/UVyNon7qTuO7SvLAUKs4Qogq94Wf+6C4oXwZB4QoBigV2Jb6LLziW+xQvcySZx9FQOBWsTB7ow8riz6Zv7Uzb3dsIEjwJRzMblZqdwGarCJNkUxo6+dqHZcSiolWR+vRXuFTAr3tLjxBZJaUjD+WdlWTWcbR46SyQVKt8GBjsPGkjbSfwepyhbT4IWwKmNDxxRgXuqcjaRYHuxaB5kPdho9yuQtjbYGA9nbYOaVYul2HRk7W1yQQyJJwQoFljMxdENTXtwHueOOrspTjSJs2MiAfVjcsNx91XTQb3ZtBN2CHnTdXYdm8Q5rKQV94JT4hwhJh/bEsAzNhGno470ccKTuaCjslZwcMAhz9SnJI2N16RZ8ahPS2Lled3iOlYKmmcCGw6fLTdKjAHBxgh3KqwQDjde81Ytq9mHFhffhSHxhADFAoUVR5dkP15I3DCT+G2TOIHjcJSjy5ojDTHgLSXOUlrXJlAsLmYf6cWmxOmbTxKnvYuScgTCW7jJTa2eHtVw4dr8wkjwrUmc6CTON6jyXOIxFITE6Y33Euer+ydRAZd4b3uZEwc56WB9wulgO6AAax06/PxsSe4xqLjEWchiyeACGBJPCFAsUEn8bk1t71pxYJ8Vd8BHZQLzTA9YcZxoM2C6tyY9XJ1Wu7PiPmu1krrqucdsRUf6I1Z8qv8eK87SUuIcVw5Z8aC7lDjr0uyxV7dJ3FcsnAh99WHF/yAEKBaoJA7Lgw65OxcHci5OcxqKag619Vtfd6JNgzewxds2Fw9r7Zdao7T46DLg1JUVmKy4XbCVFFNhR5NgpOd0+Tbn4l4+Z8YxF++GKJuLt2lAJ/FWgRiOtp3EfS6eiwF7Jc6TMUHnVTAXbxLfIP/K24iXuuNciC5Mm4tfcqVtSHwOAYoFKon7tHp3RR3dMq04nGQfBtJh5l/7APuEpHBx6aTSK+VriMmxYucOTxonuESN2a0lS4m7jx0lEe5Cx7I5JwWRnjVbMQ1rOE0rYh7QFuRds74EvyPxqIB9A4YyO4nb9cJL8QrUEvclNPfJuZyfVpzr9rdwVIwpCtua/3Kz5uyF9C+u8CHxCQIUC3yM9SV/qjFwXgyJJwQoFhgS/+kYEk8IUCwwJP7TMSSeEKBYQJO1EuYSHxgY+GkYVrxBgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2Er5L45R+o+TQEKBY4c6U/8IX59HzJEvsjox3F/AmUyz/r8Y2xR+JvWGt/3SdxPoMwYbf5qt/dXkH/F6BYYPEbdXvckT8+52s+QWbBWU4qrkn8wG+vl1HU9krcI6N9+mZcOPrht0ct8bcde953X/vtf+K0EfIK+r8AxQJzifMhCXu2cqZDewjyNPN8ghU/WeLN+n7yZrSRQhW1xF+eDkh8hdBZeLGREcGrMMD7AzpdVKwWeMvjVvWRtL6xxyRAscBM4vHYJNDCIZn82nOcNOYhFjwzxUhPHmztFq8rPDZlz2+3oG4eZc1T85EqHDBngO6BPYBlT5MjiT+Lmc9cRUC2jIz26ZuBJ0Slf25bSvz55gWt87xH4rglFrfOm9xH1XlULHYPPgMfcataJK0I4fVdIUCxwEzi8VA4MJO4PXvtxjysI7W33WTwNP5jVDM0hD1IbiFjtgxlZsXwBJ/B9PGBRXOOjYvxhOe2sIdWspfZQehmXAR7JA4r/vpSS5z3is3dN/luPI2MExBxdFrYr2/szQpQLDCXuD997UFV+9jgODiFepk52/GAt4dhga67cDDphFs74q0PGC0vsrUTlmxyx2eOudLNuAj2SBwW/Gk2H++mNvYse4TRzybnmT4qlvl24ZRFJK0WwutP0DwFAhQLFFacstjZWQBxEhgdISIOt7iD+NxLPMKwRlA3pnaJW0aLmIzTVjTLgsQtNSTOQ9barcwJSjfjIqjn4rTi+yRu4ztv7MFR1XpCTMquZFQVoFhgJnEPb1pKHPw74+qnu2BrM4m7Fae73VnxuJyrn45+bcWjzAlKN+MiqCX+8IB/9ZdmviKDeRDfcOZljbiMiuXmoMWtikhaEcLru0KAYoH5ivptWMD5XJyz6miOACM/bS3g+tKKT0HdLCih5fdA4gYcZC6LGMXoxrDOORfPKIy9FZe6GRfBnu/FMW5C5ZXEfYTl2gg3oaDDxmBdy6hYHHgR6MviVmUkrQjh9V0hQLHA4ntx86m7DQZMosYVLx4juE3OGXsxg62lxO8yqBuX0SPeuIdKniK12V4nHCZwuS3T8LI+DLSAbA1SN+MiGD9gTQhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIknBCgW0GSthCHxhADFApqslTAknhCgWECTtRKGxBMCFAtoslbCkHhCgGIBTdZKGBJPCFAsoMlaCUPiCQGKBTRZK2FIPCFAsYAmayUMiScEKBbQZK2EIfGEAMUCmqyVMCSeEKBYQJO1EobEEwIUC2iyVsKQeEKAYgFN1koYEk8IUCygyVoJQ+IJAYoFNFkrYUg8IUCxgCZrJQyJJwQoFtBkrYQh8YQAxQKarJUwJJ4QoFhAk7UShsQTAhQLaLJWwpB4QoBiAU3WShgSTwhQLKDJWglD4gkBigU0WSthSDwhQLGAJmslDIkn/n97V7TcKAwDO4UQ+P8fvt2VLAw4aZuGuQ7WPjSAhSz5vJbEPagDFxvo0+uekBQPdOBiAz/0Wh19T33hhTeAtfdpwa7tMFoa7vspv2HmcZnWxso/Q23f5/SS099DUjzQgYsNVJ1J1T4UbT2NLWNp27/Bl1txL/D4BWtm3tTARqRPYQ3GK3xJ8UPD9G/Y7n1ZH+M+f7BXqpoiP3O5paiyD94cV/ptSIoHOnCxgV3zYTxge27uU5DiVIr/Jpb+nOJHgTdE8RJ9N+2Sv6mmsq+cFOcgKR7owMUGjhS36HobnOLGeAV5bF3fvvMdt4iLI/JfNfumEDuTs1E4W/urSbl++II9nMa7+n3r4Jhn7nF2LF+02Tk7Ooj7FNaBnDpck7c+ZxNzTKZ+5YvLq/E4GYzfQmS8fKfW0mGcrcZxz0QFKuDiKNNHPlmMbTCAM1M1lLiIzeoJgBmADMPcpdZJ7g0wqPiFR+btdq7iDvuqb+2D6PgxnNgHPSke6MDFBo4Un3iBPbul+IwfxKpCcWx7HgWjyIH9iXcskklgJG0WDYjwUAg1kzf05xCmIS1EycKwOylgRNNzMKhoUl4v5WaAoniRxwAz5ZnHg8nSWJqG0ZKhUyNdIbN0MGgcbkC2oviCIdLWRLACGJrs4HADFvJ7W0jgVZ0GXCnIysTtXBSnO7dJP8U+X5hzkRQPdOBiA7tafHHuzdq1VaLObY6BQnGSlbEJe1d0w3NSrMpSP6cyoEd4N1JT47EozmMlorgpDorzhFhzbAkgMxaJI1GHvA+YmBHajV1jqx7ZS7Uk3ZjMkhLF3Z4iIn1mm88jLVieFXzCWWqKH+cKd3BTL+auoHg/kuKBDlxsoBHFsQm5Q3cUFzYUvxWKE3iORNkprkQaZMAlKU4t0BibGWoxmW6ZtwbFmcyuFGfUdE1xApFA/GMMMnmYYWRSfSEneCmKExXFeeEMWynuR4FTnGl2TXF9TRM53QCjeJ1Yc5UY6bcU388ld7RWeGj2lYX57b/hcyTFAx242ECL4veRu/UYxYFHUdyABNT2N6vZx1EcA6UCZs4rOmB2hrkqijMZdk2VeZYxS7XLfxHFV/sfRHFqC4qTiM+iuLu7oThPGp1NXK2HUVy5vX2/yCj+n9CBiw20KI5Ygz14rMWBqMUZTncZqOIZdyz398BsYMZlqcU9WttUowKfrrnjWdiD4vy6FhTXhEWTl8KGQkGXZ8V7i1rc9LNc9lq8OqJUH5cyoKJ4McCPo7miuNXi8TGgRXEbhiAvuDCWFOzmsvXT6BD2+cKci6R4oAMXG2hR3Mrq4xd15LwRxRG67BiIhJl/dXNjtntDisu0FKWufp1MhoHRzDNpDPATNapbiQXFLcd2TYSl0P7ZnEWBy9OygTK0cC0rvA4oH+SNavYJ/kBxN4AzQ0lNcc3nWYoZcKC4XfO/8vlpn4ZwCfZzmTv8is/Cwu3zhTkXSfFABy428JrXm0Q18aeRFA904GIDSfGrIyke6MDFBpLiV0dSPNCBiw306XVP2FI8kUhcDTXFE4nENZEUTyQujaR4InFpJMUTiUvjH/ICR6aHF82/AAAAAElFTkSuQmCC");
            fotoDTO.setNombre("foto1");
            fotoDTO.setIdFoto(0);

            productoDTO.setIdProducto(0);
            productoDTO.setIdUsuario(1);
            productoDTO.setIdCategoria(1);
            productoDTO.setNombre("testProducto1");
            productoDTO.setDescripcion("Producto3 cargado de prueba");
            productoDTO.setPrecio(10.5);
            productoDTO.setCantidadDisponible(5);
            productoDTO.setFechaFabricacion("01/09/2022");
            productoDTO.addFotos(fotoDTO);

            Producto p = productoBO.agregarProducto(productoDTO.build());
            System.out.println("se agrego el producto \n" + p.toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
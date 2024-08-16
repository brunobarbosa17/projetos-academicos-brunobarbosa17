import { IsNotEmpty, IsString } from 'class-validator'

export class ResetPasswordRequestDto
  implements Readonly<ResetPasswordRequestDto>
{
  public constructor(init?: Partial<ResetPasswordRequestDto>) {
    Object.assign(this, init)
  }
  @IsString()
  @IsNotEmpty()
  token: string

  @IsString()
  @IsNotEmpty()
  password: string

  @IsString()
  @IsNotEmpty()
  confirmPassword: string
}

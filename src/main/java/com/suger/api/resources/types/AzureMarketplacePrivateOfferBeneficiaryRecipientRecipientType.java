package com.suger.api.resources.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType {
  public static final AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType CSP_CUSTOMER = new AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType(Value.CSP_CUSTOMER, "cspCustomer");

  public static final AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType BILLING_GROUP = new AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType(Value.BILLING_GROUP, "billingGroup");

  private final Value value;

  private final String string;

  AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType && this.string.equals(((AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case CSP_CUSTOMER:
        return visitor.visitCspCustomer();
      case BILLING_GROUP:
        return visitor.visitBillingGroup();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType valueOf(
      String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "cspCustomer":
        return CSP_CUSTOMER;
      case "billingGroup":
        return BILLING_GROUP;
      default:
        return new AzureMarketplacePrivateOfferBeneficiaryRecipientRecipientType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    CSP_CUSTOMER,

    BILLING_GROUP,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitCspCustomer();

    T visitBillingGroup();

    T visitUnknown(String unknownType);
  }
}